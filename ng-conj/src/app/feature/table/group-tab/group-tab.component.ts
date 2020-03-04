import { Component, Input, OnInit } from '@angular/core';
import { GroupDto } from '@app/models/group-dto';

@Component({
  selector: 'app-group-tab',
  templateUrl: './group-tab.component.html',
  styleUrls: ['./group-tab.component.scss'],
})
export class GroupTabComponent implements OnInit {

  @Input()
  groupValue: GroupDto;

  constructor() {
  }

  ngOnInit(): void {
  }

}
