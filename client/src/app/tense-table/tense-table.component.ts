import {Component} from '@angular/core';
import {StateStorageService} from "../services/state-storage.service";
import {TenseObj} from "../models/baseTense";

@Component({
  selector: 'app-tense-table',
  templateUrl: './tense-table.component.html',
  styleUrls: ['./tense-table.component.scss']
})
export class TenseTableComponent {

  displayedColumns: string[] = ['index', 'presentTense', 'presentPerfectTense'];
  dataSource: Array<TenseObj> = this.storage.table.tenseArray;

  constructor(private storage: StateStorageService) {
  }

}
