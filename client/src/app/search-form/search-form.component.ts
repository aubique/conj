import {Component} from '@angular/core';
import {ApiService} from "../services/api.service";
import {StateStorageService} from "../services/state-storage.service";
import {VerbFactoryService} from "../services/verb-factory.service";

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.scss'],
  providers: [ApiService],
})
export class SearchFormComponent {

  private searchField: string;
  private errorMsg: string;

  constructor(
    private find: ApiService,
    private storage: StateStorageService,
    private factory: VerbFactoryService,
  ) {
  }

  private onClickFind() {
    this.storage.obs$ = this.find.getOneVerb(this.searchField);
    this.storage.obs$.subscribe((baseVerb) => {
      this.storage.table = this.factory.parseVerbObj(baseVerb);
      this.storage.table.tenseArray.forEach(e => console.log(e));
    }, error => this.errorMsg = error);
  }

}
