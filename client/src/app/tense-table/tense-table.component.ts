import {Component} from '@angular/core';
import {StateStorageService} from "../services/state-storage.service";
import {BaseTense} from "../models/base-tense";
import {AbstractFactory} from "../mapper/abstract-factory";
import {VerbFactory} from "../mapper/verb-factory";
import {Verb} from "../models/verb";
import {JsonVerb} from "../models/json-verb";

@Component({
  selector: 'app-tense-table',
  templateUrl: './tense-table.component.html',
  styleUrls: ['./tense-table.component.scss']
})
export class TenseTableComponent {

  private toVerb: AbstractFactory<Map<string, JsonVerb>, Verb> = new VerbFactory();
  private displayedColumns: string[] = ['index', 'presentTense', 'presentPerfectTense', 'imperfectTense', 'futureTense'];
  private dataSource: Array<BaseTense>;

  constructor(private storage: StateStorageService) {
    // this.storage.obs$.subscribe(() => this.updateDataSource());
    this.storage.obs$.subscribe((jsonDict) => {
      this.storage.table = this.toVerb.create(jsonDict);
      this.updateDataSource();
    });
  }

  public updateDataSource(): void {
    this.dataSource = this.storage.table.tenseArray;
  }

}
