import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {BaseVerb} from "../models/baseVerb";
import {catchError} from "rxjs/operators";

@Injectable()
export class ApiService {

  constructor(
    private http: HttpClient,
  ) {
  }

  public getOneVerb(verbToSearch: string = "aller"): Observable<BaseVerb> {
    return this.http
      .get<BaseVerb>("http://localhost:8080/api/find/" + verbToSearch)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    return Observable.throw(error.message || 'Server Error');
  }

}
