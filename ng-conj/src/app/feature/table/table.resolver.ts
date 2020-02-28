import { Injectable } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { VerbDto } from '@app/models/verb-dto';
import { FacadeService } from '@app/services/facade.service';
import { Observable } from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class TableResolver implements Resolve<VerbDto> {

  constructor(
    private facade: FacadeService,
    private activatedRoute: ActivatedRoute,
  ) {
  }

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot,
  ): Observable<VerbDto> | Promise<VerbDto> | VerbDto {

    // Stream chain ( ~/core/services/facade ).then( ~/core/http/api ).then( /assets/mock/json )
    let $dto = this.facade.searchVerb(route.params['name'])
      .pipe(
        delay(1500),
      );
    // Toggle loading state because form is about to get loaded
    $dto.subscribe(() => this.facade.loadingState.next(false));

    console.log('Fetched Verb DTO:\n', $dto);
    // console.log($dto);
    return $dto;
  }
}
