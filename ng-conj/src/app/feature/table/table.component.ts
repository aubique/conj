import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VerbDto } from '@app/models/verb-dto';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
})
export class TableComponent implements OnInit {

  $verb: Observable<VerbDto>;

  constructor(
    private route: ActivatedRoute,
  ) {
  }

  ngOnInit(): void {
    this.loadTenses();
  }

  private loadTenses(): void {
    // Retrieve DTO from ( resolver ).then( facade ).then( api )
    this.$verb = this.route.data
      .pipe(
        map((data) => data.verbResolved),
      );

    //TODO: debug output to remove
    console.log('data.verbResolved.$stream:', this.$verb);
    this.$verb.subscribe(value => {
      console.log('data.verbResolved.value:\n', value);
    });
  }
}
