import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {JsonVerb} from "../models/json-verb";
import {Verb} from "../models/verb";

@Injectable({
  providedIn: 'root'
})
export class StateStorageService {

  public table: Verb;
  public obs$: Observable<Map<string, JsonVerb>>;
  public isInitiated: boolean = false;
}
