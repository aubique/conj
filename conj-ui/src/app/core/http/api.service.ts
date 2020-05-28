import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { VerbDto } from '@app/models/verb-dto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {

  constructor(private http: HttpClient) {
  }

  public doGetRequest(verbName: string): Observable<any> {
    //TODO: debug output
    console.log(`Do Get Request: ${verbName}`);

    return this.http
      .get<VerbDto>('/assets/mock/foutre.json');
    // .get<VerbDto>(this.getUrlMaxVerb(verbName));
  }

  private getUrlMaxVerb(name: string): string {
    // return `http://localhost:${environment.port}/api/max/${name}`;
    return `/api/max/${name}`;
  }
}
