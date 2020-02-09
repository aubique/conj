import {Component} from '@angular/core';
import {StateStorageService} from "../services/state-storage.service";
import {BaseTense} from "../models/base-tense";
import {JsonConverter} from "../services/json-converter";

@Component({
  selector: 'app-tense-table',
  templateUrl: './tense-table.component.html',
  styleUrls: ['./tense-table.component.scss']
})
export class TenseTableComponent {

  displayedColumns: string[] = ['index', 'presentTense', 'presentPerfectTense', 'imperfectTense', 'futureTense'];
  dataSource: Array<BaseTense>;

  constructor(private storage: StateStorageService, private toList: JsonConverter) {
    // this.storage.obs$.subscribe(() => this.updateDataSource());
    this.storage.obs$.subscribe((arr) => {
      this.storage.table = this.toList.map(arr);
      this.updateDataSource();
    });
  }

  public updateDataSource(): void {
    this.dataSource = this.storage.table.pop().tenseArray;
  }

}
