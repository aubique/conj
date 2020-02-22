import { ApplicationRef, Injectable } from '@angular/core';
import { ThemingEnum } from './theming.enum';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class ThemingService {

  theme = new BehaviorSubject(ThemingEnum.darkTheme);

  constructor(private ref: ApplicationRef) {
    const lightModeOn = window.matchMedia &&
      window.matchMedia('(prefers-color-scheme: light)').matches;

    if (lightModeOn) {
      this.theme.next(ThemingEnum.lightTheme);
    }

    window.matchMedia('(prefers-color-scheme: dark)')
      .addEventListener('change', ev => {
        const turnOn = ev.matches;
        this.theme.next(turnOn ? ThemingEnum.darkTheme : ThemingEnum.lightTheme);
        this.ref.tick();
      });
  }
}
