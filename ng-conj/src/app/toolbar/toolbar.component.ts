import { Component, OnInit } from '@angular/core';
import { ThemingEnum } from '../shared/theming.enum';
import { ThemingService } from '../shared/theming.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss'],
})
export class ToolbarComponent implements OnInit {

  public theme: typeof ThemingEnum = ThemingEnum;

  constructor(private theming: ThemingService) {
  }

  ngOnInit(): void {
  }

  onClickMenu(styleTheme: ThemingEnum): void {
    this.theming.theme.next(styleTheme);
    console.log(styleTheme);
  }
}
