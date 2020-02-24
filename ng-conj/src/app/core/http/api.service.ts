import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JsonDto } from '@app/models/json-dto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {

  constructor(private http: HttpClient) {
  }

  public doGetRequest(infinitive: string): Observable<any> {
    //TODO: debug output
    console.log(`Do Get Request: ${infinitive}`);

    return this.http
      .get<Array<JsonDto>>('/assets/mock/avoir.json');
  }
}
