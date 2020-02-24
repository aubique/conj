import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { FacadeService } from '@app/services/facade.service';
import { Observable } from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class TensesResolver implements Resolve<string> {

  constructor(private facade: FacadeService) {
  }

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot,
  ): Observable<string> | Promise<string> | string {

    // Call ( ~/core/services/facade ).then( ~/core/http/api )
    let $stream = this.facade.searchVerb(route.params['name'])
      .pipe(delay(1500));

    console.log(`Fetched $verbResolved: ${$stream}`);
    return $stream;
  }
}
