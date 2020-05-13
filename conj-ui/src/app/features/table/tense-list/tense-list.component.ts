import { Component, Input, OnInit } from '@angular/core';
import { TenseDto } from '@app/models/tense-dto';

@Component({
  selector: 'app-tense-list',
  templateUrl: './tense-list.component.html',
  styleUrls: ['./tense-list.component.scss'],
})
export class TenseListComponent implements OnInit {

  @Input()
  tenseValue: TenseDto;

  //columnToShow = ['group'];

  constructor() {
  }

  ngOnInit(): void {
    console.log(this.tenseValue.list);
  }

}
