import { Injectable } from '@angular/core';
import { Theme } from '@app/models/theme';
import { InputLocationEnum } from '@shared/enums/input-location.enum';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class StoreService {

  public loadingState$ = new Subject<boolean>();
  public inputLocationState$ = new Subject<InputLocationEnum>();

  constructor() {
  }
}
