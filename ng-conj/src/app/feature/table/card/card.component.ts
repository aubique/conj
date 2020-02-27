import { Component, Input, OnInit } from '@angular/core';
import { TenseDto } from '@app/models/tense-dto';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss'],
})
export class CardComponent implements OnInit {

  @Input()
  tenseList: TenseDto;

  //columnToShow = ['tense'];

  constructor() {
  }

  ngOnInit(): void {
    console.log(this.tenseList);
  }

}
