import {Component, OnInit} from '@angular/core';
import {ApiService} from "../services/api.service";
import {StateStorageService} from "../services/state-storage.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.scss'],
  providers: [ApiService],
})
export class SearchFormComponent implements OnInit {

  public form: FormGroup;
  private searchFieldValue: string;
  private isSearchFailed: boolean;

  constructor(
    private find: ApiService,
    private storage: StateStorageService,
  ) {
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      searchField: new FormControl(null,
        [Validators.required, Validators.minLength(4)])
    })
  }

  public onClickFind() {
    if (this.form.valid) {
      console.log('Submit form values: ', {...this.form.value});
      this.searchFieldValue = (<string>this.form.get('searchField').value).toLowerCase();
      this.storage.obs$ = this.find.searchVerb(this.searchFieldValue);
      //TODO: put this code block into a separate component
      this.storage.obs$.subscribe(
        (success) => this.isSearchFailed = false,
        (error) => {
          //TODO: refine isSearchFailed handler to look for the closest match
          this.isSearchFailed = true;
          console.log(this.searchFieldValue + ' isn\'t found');
          console.log('Aucun verbe n\'a été trouvé');
          this.form.reset();
        },
        () => console.log('HTTP request has been completed.')
      );
    }
  }
}
