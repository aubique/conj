import { Component, OnInit } from '@angular/core';
import { FacadeService } from '@app/services/facade.service';
import { InputLocationEnum } from '@shared/enums/input-location.enum';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {

  isNotHomePage: boolean;

  constructor(private facade: FacadeService) {
  }

  ngOnInit(): void {
    this.facade.inputLocation
      .subscribe((location) => {
        if (location === InputLocationEnum.Home) {
          this.isNotHomePage = false;
        } else {
          this.isNotHomePage = true;
        }
      });
  }
}
