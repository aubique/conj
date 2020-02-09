import {Component} from '@angular/core';
import {ApiService} from "../services/api.service";
import {StateStorageService} from "../services/state-storage.service";

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
  ) {
  }

  private onClickFind() {
    this.storage.obs$ = this.find.searchVerb(this.searchField.toLowerCase());
    // this.storage.obs$.subscribe((arr) => {
    //   this.storage.table = this.toListOfVerbs.map(arr);
    //   // this.storage.table[0].tenseArray.forEach(e => console.log(e));
    // }, error => this.errorMsg = error);
  }
}
