import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiService} from "./services/api.service";
import {StateStorageService} from "./services/state-storage.service";
import {VerbFactoryService} from "./services/verb-factory.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [ApiService, VerbFactoryService]
})
export class AppComponent implements OnInit {

  constructor(
    private http: HttpClient,
    private find: ApiService,
    private storage: StateStorageService,
  ) {
  }

  ngOnInit(): void {
  }
}
