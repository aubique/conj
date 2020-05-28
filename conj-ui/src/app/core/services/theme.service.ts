import { OverlayContainer } from '@angular/cdk/overlay';
import { Injectable, OnInit } from '@angular/core';
import { Theme } from '@app/models/theme';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ThemeService implements OnInit {

  // private themes: BehaviorSubject<Theme[]>;
  private _currentTheme: BehaviorSubject<Theme>;

  constructor(private overlay: OverlayContainer) {
  }

  ngOnInit(): void {
    this.initThemes();
  }

  get currentTheme$(): BehaviorSubject<Theme> {
    return this._currentTheme;
  }

  private initThemes(): void {
    const lightDefault = {name: 'light-default', display: 'Default', next: null} as Theme;
    const darkDefault = {name: 'dark-default', display: 'Default', next: null} as Theme;

    lightDefault.next = darkDefault;
    darkDefault.next = lightDefault;

    // this.themes = new BehaviorSubject<Theme[]>([lightDefault, darkDefault]);
    this._currentTheme = new BehaviorSubject<Theme>(darkDefault);

    this.setOverlayTheme(this._currentTheme.value.name);
    console.log(this._currentTheme);//TODO remove out
  }

  private setOverlayTheme = (newTheme: string, oldTheme?: string) => {
    if (oldTheme)
      this.overlay.getContainerElement().classList.remove(oldTheme);
    this.overlay.getContainerElement().classList.add(newTheme);
  };

  public setNextTheme(): void {
    this.setOverlayTheme(this._currentTheme.value.next.name, this._currentTheme.value.name);
    this._currentTheme.next(this._currentTheme.value.next);
  }
}
