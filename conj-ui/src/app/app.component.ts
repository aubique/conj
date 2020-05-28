import { Component, OnDestroy, OnInit } from '@angular/core';
import { Theme } from '@app/models/theme';
import { FacadeService } from '@app/services/facade.service';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit, OnDestroy {

  // themeClass = 'default';
  themeClass: BehaviorSubject<Theme>;

  constructor(
    private service: FacadeService,
  ) {
    this.service.ngOnInit();
  }

  ngOnInit(): void {
    this.themeClass = this.service.themeState$;
    // this.service.themeState$.subscribe((t: Theme) => this.themeClass = t.name);
  }

  ngOnDestroy(): void {
  }
}
