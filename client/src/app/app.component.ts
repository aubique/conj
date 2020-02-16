import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiService} from "./services/api.service";
import {StateStorageService} from "./services/state-storage.service";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [ApiService]
})
export class AppComponent {

  constructor(
    private http: HttpClient,
    private find: ApiService,
    public storage: StateStorageService,
    private titleService: Title,
  ) {
    this.titleService.setTitle("Le Conjugueur");
  }

  public update() {
    return null;
  }

}
