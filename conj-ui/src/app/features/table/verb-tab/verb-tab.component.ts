import { Component, Input, OnInit } from '@angular/core';
import { GroupDto } from '@app/models/group-dto';
import { VerbDto } from '@app/models/verb-dto';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-verb-tab',
  templateUrl: './verb-tab.component.html',
  styleUrls: ['./verb-tab.component.scss'],
})
export class VerbTabComponent implements OnInit {

  @Input()
  verb$: Observable<VerbDto>;
  group$: Observable<GroupDto>;

  constructor() {
  }

  ngOnInit(): void {

  }

}
