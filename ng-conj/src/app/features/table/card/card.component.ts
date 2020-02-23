import { Component, OnInit } from '@angular/core';

export class Tense {
  title: string;
  list: Array<string>;
}

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss'],
})
export class CardComponent implements OnInit {

  public past_simple = new Tense();
  columnToShow = ['tense'];

  constructor() {
    this.past_simple.title = 'Passé Composé';
    this.past_simple.list = ['J\' ai', 'Tu as', 'Il/Elle a', 'Nous avons', 'Vous avez', 'Ils ont'];
  }

  ngOnInit(): void {
  }

}
