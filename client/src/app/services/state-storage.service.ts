import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {BaseVerb} from "../models/baseVerb";
import {Verb} from "../models/verb";

@Injectable({
  providedIn: 'root'
})
export class StateStorageService {

  public table: Verb;
  public obs$: Observable<BaseVerb>;
  public isFound: boolean = true;
}
