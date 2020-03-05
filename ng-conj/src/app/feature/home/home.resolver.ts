import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { FacadeService } from '@app/services/facade.service';
import { InputLocationEnum } from '@shared/enums/input-location.enum';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class HomeResolver implements Resolve<null> {

  constructor(private facade: FacadeService) {
  }

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot,
  ): Observable<null> | Promise<null> | null {
    // Change the input-location state during routing resolve
    this.facade.inputLocation.next(InputLocationEnum.Home);
    return null;
  }
}
