import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {JsonVerb} from "../models/json-verb";
import {catchError} from "rxjs/operators";
import {StateStorageService} from "./state-storage.service";

@Injectable()
export class ApiService {

  constructor(
    private http: HttpClient,
    private storage: StateStorageService
  ) {
  }

  public searchVerb(verbToSearch: string = "aller"): Observable<Map<string, JsonVerb>> {
    return this.http
      .get<Map<string, JsonVerb>>("http://localhost:8080/api/find/" + verbToSearch)
      .pipe(
        catchError((err) => {
            if (err.status === 500) {
              return throwError(err);
            }
          }
        )
      );
  }

  private handleError(error: HttpErrorResponse) {
    return Observable.throw(error.message || 'Server Error');
  }

}
