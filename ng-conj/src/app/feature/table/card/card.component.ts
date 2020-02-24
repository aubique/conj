import { Component, Input, OnInit } from '@angular/core';
import { JsonDto } from '@app/models/json-dto';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss'],
})
export class CardComponent implements OnInit {

  @Input()
  tenseList: JsonDto;

  //columnToShow = ['tense'];

  constructor() {
  }

  ngOnInit(): void {
    console.log(this.tenseList);
  }

}
