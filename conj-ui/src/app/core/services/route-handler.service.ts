import { Location } from '@angular/common';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { DataResolve } from '@app/models/data-resolve';
import { VerbDto } from '@app/models/verb-dto';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class RouteHandlerService {

  private $verbStream: Observable<VerbDto>;
  private route: ActivatedRoute;
  private location: Location;

  constructor(
    activatedRoute: ActivatedRoute,
    location: Location,
  ) {
    this.route = activatedRoute;
    this.location = location;
  }

  get stream(): Observable<VerbDto> {
    return this.$verbStream;
  }

  public extractVerbFromRoute(): RouteHandlerService {
    this.$verbStream = this.route.data
      .pipe(
        map((data: DataResolve) => data.verbResolved),
      );

    return this;
  }

  public subscribeToChangeUrl(): RouteHandlerService {
    this.route.data.subscribe((data: DataResolve) =>
      this.changeUrl(data.verbResolved.name));

    return this;
  }

  private changeUrl(url: string): void {
    if (!this.location.isCurrentPathEqualTo('/' + url))
      this.location.go(url);
  }
}
