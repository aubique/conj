import { Injectable } from '@angular/core';
import { ApiService } from '@app/http/api.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FacadeService {

  constructor(
    private api: ApiService,
  ) {
  }

  public searchVerb(name: string): Observable<any> {
    return this.api.doGetRequest(name);
  }
}
