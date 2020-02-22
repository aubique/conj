import { Component, HostBinding, OnDestroy, OnInit } from '@angular/core';
import { ThemingService } from './shared/theming.service';
import { ThemingEnum } from './shared/theming.enum';
import { Subscription } from 'rxjs';
import { StorageService } from './core/storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit, OnDestroy {

  public theme: typeof ThemingEnum = ThemingEnum;
  private themingSubscription: Subscription;

  constructor(
    private theming: ThemingService,
    public storage: StorageService,
  ) {
  }

  @HostBinding('class')
  public cssClass: string;

  ngOnInit(): void {
    this.themingSubscription = this.theming.theme
      .subscribe((newStyle) => {
          this.cssClass = newStyle;
        },
      );
  }

  ngOnDestroy(): void {
    this.themingSubscription.unsubscribe();
  }
}
