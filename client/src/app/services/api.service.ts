import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BaseVerb} from "../models/baseVerb";

@Injectable()
export class ApiService {

  constructor(
    private http: HttpClient,
  ) {
  }

  public getOneVerb(verbToSearch: string = "aller"): Observable<BaseVerb> {
    return this.http
      .get<BaseVerb>("http://localhost:8080/api/find/" + verbToSearch);
  }

  private handleError(error: Response) {
    return Observable.throw(error || 'Server Error');
  }

}
