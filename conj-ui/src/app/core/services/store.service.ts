import { Injectable } from '@angular/core';
import { InputLocationEnum } from '@shared/enums/input-location.enum';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class StoreService {

  public loadingState$ = new Subject<boolean>();
  public inputLocationState = new Subject<InputLocationEnum>();

  constructor() {
  }
}
