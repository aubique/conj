import {Injectable} from '@angular/core';
import {ErrorObserver, Observable} from "rxjs";
import {BaseVerb} from "../models/baseVerb";
import {Verb} from "../models/verb";

@Injectable({
  providedIn: 'root'
})
export class StateStorageService {

  public table: Array<Verb>;
  public obs$: Observable<Array<BaseVerb>>;
  public isInitiated: boolean = false;
}
