import { OverlayContainer } from '@angular/cdk/overlay';
import { Injectable, OnInit } from '@angular/core';
import { Theme } from '@app/models/theme';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ThemeService implements OnInit {

  private lightDefault: Theme;
  private darkDefault: Theme;
  private static readonly STORAGE_THEME = 'theme';
  private _currentTheme: BehaviorSubject<Theme>;

  constructor(private overlay: OverlayContainer) {
    this.lightDefault = {name: 'light-default', display: 'Default', next: null} as Theme;
    this.darkDefault = {name: 'dark-default', display: 'Default', next: null} as Theme;
    this.lightDefault.next = this.darkDefault;
    this.darkDefault.next = this.lightDefault;
  }

  ngOnInit(): void {
    this.initThemes();
  }

  get currentTheme$(): BehaviorSubject<Theme> {
    return this._currentTheme;
  }

  private initThemes(): void {
    let storageTheme: string;

    storageTheme = localStorage.getItem(ThemeService.STORAGE_THEME);
    this.initThemeState(storageTheme);
    console.log(storageTheme);//TODO: remove output
    this.setOverlayTheme(this._currentTheme.value.name);
  }

  private initThemeState(storageTheme: string): void {
    switch (storageTheme) {
      case this.darkDefault.name: {
        this._currentTheme = new BehaviorSubject<Theme>(this.darkDefault);
        break;
      }
      case this.lightDefault.name: {
        this._currentTheme = new BehaviorSubject<Theme>(this.lightDefault);
        break;
      }
      default: {
        console.log('TRIGGER LOCAL STORAGE, null theme');
        this._currentTheme = new BehaviorSubject<Theme>(this.darkDefault);
        break;
      }
    }
  }

  private setOverlayTheme = (newTheme: string, oldTheme?: string) => {
    if (oldTheme)
      this.overlay.getContainerElement().classList.remove(oldTheme);
    this.overlay.getContainerElement().classList.add(newTheme);
  };

  public setNextTheme(): void {
    this.setOverlayTheme(this._currentTheme.value.next.name, this._currentTheme.value.name);
    this._currentTheme.next(this._currentTheme.value.next);
    localStorage.setItem(ThemeService.STORAGE_THEME, this._currentTheme.value.name);
  }
}
