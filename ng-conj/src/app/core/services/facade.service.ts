import { Location } from '@angular/common';
import { Injectable, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '@app/http/api.service';
import { VerbDto } from '@app/models/verb-dto';
import { RouteHandlerService } from '@app/services/route-handler.service';
import { StoreService } from '@app/services/store.service';
import { Observable, Subject } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class FacadeService implements OnInit {

  constructor(
    private store: StoreService,
    private api: ApiService,
    private titleService: Title,
    private router: Router,
    private location: Location,
  ) {
  }

  ngOnInit(): void {
    console.log('=======\nTRIGGER FACADE INIT\n=======');
    this.changeTitle(null);
  }

  get loadingState(): Subject<boolean> {
    return this.store.$loadingState;
  }

  public searchVerb(name: string): Observable<VerbDto> {
    //TODO: verification needs to be performed
    console.log('search verb');
    return this.api.doGetRequest(name)
      .pipe(
        tap((verb: VerbDto) => {
          this.changeTitle(verb.name);
          this.location.onUrlChange((n) => console.log('TRIGGER url change: ', n));
        }),
      );
  }

  public initRouteHandler(route: ActivatedRoute): RouteHandlerService {
    return new RouteHandlerService(route, this.location);
  }

  public changeTitle(verb: string): void {
    if (verb) {
      this.titleService.setTitle(`Conjuguer «${verb}»`);
    } else {
      // Null for param ${verb} indicates the initial page load
      this.titleService.setTitle('Le Conjuguer');
    }
  }

  public navigateTo(url: string): void {
    this.router.navigate([url]);
  }
}
