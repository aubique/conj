import { Component, OnInit } from '@angular/core';
import { StorageService } from '../core/storage.service';

@Component({
  selector: 'app-toggle',
  templateUrl: './toggle.component.html',
  styleUrls: ['./toggle.component.scss'],
})
export class ToggleComponent implements OnInit {

  constructor(private storage: StorageService) {
  }

  ngOnInit(): void {
  }

  onClickToggle(): void {
    this.storage.isAttachedToHeader = !this.storage.isAttachedToHeader;
  }
}
