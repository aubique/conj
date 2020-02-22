import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class StorageService {

  public isAttachedToHeader = true;

  constructor() {
  }
}
