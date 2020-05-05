import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VerbDto } from '@app/models/verb-dto';

import { FacadeService } from '@app/services/facade.service';
import { RouteHandlerService } from '@app/services/route-handler.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
})
export class TableComponent implements OnInit {

  $verb: Observable<VerbDto>;
  private routeHandler: RouteHandlerService;

  constructor(
    private facade: FacadeService,
    private route: ActivatedRoute,
  ) {
    // Init a new RouteHandlerService to manage the state of (<ActivatedRoute>route).data
    this.routeHandler = this.facade.initRouteHandler(route);
  }

  ngOnInit(): void {
    this.$verb = this.routeHandler
      .extractVerbFromRoute()
      .subscribeToChangeUrl()
      .stream;
  }
}
