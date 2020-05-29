import { Component, OnInit } from '@angular/core';
import { FacadeService } from '@app/services/facade.service';
import { ThemeService } from '@app/services/theme.service';
import { InputLocationEnum } from '@shared/enums/input-location.enum';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {

  isNotHomePage: boolean;

  constructor(private service: FacadeService, private themeService: ThemeService) {
  }

  ngOnInit(): void {
    this.service.inputLocation
      .subscribe((location) => {
        this.isNotHomePage = location !== InputLocationEnum.Home;
      });
  }

  onSlideToggle(): void {
    this.service.toggleTheme();
  }
}
