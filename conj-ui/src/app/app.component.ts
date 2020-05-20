import { Component, OnDestroy, OnInit } from '@angular/core';
import { FacadeService } from '@app/services/facade.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit, OnDestroy {

  constructor(private facade: FacadeService) {
    this.facade.ngOnInit();
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
  }
}
