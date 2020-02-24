import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JsonDto } from '@app/models/json-dto';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
})
export class TableComponent implements OnInit {

  $tenses: Observable<JsonDto[]>;

  constructor(
    private route: ActivatedRoute,
  ) {
  }

  ngOnInit(): void {
    this.loadTenses();
  }

  private loadTenses(): void {
    this.$tenses = this.route.data
      .pipe(map(data => data.verbResolved));
    //TODO: remove debug output
    console.log(this.$tenses);
    this.$tenses.subscribe(value => {
      console.log(value);
    });
  }
}
