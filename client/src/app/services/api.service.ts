import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {JsonVerb} from "../models/json-verb";
import {catchError} from "rxjs/operators";

@Injectable()
export class ApiService {

  constructor(
    private http: HttpClient,
  ) {
  }

  public searchVerb(verbToSearch: string = "aller"): Observable<Map<string, JsonVerb>> {
    return this.http
      .get<Map<string, JsonVerb>>("http://localhost:8080/api/find/" + verbToSearch)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    return Observable.throw(error.message || 'Server Error');
  }

}
