import { Injectable, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ApiService } from '@app/http/api.service';
import { VerbDto } from '@app/models/verb-dto';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class FacadeService implements OnInit {

  constructor(
    private api: ApiService,
    private titleService: Title,
  ) {
  }

  ngOnInit(): void {
    console.log('=======\nTRIGGER FACADE INIT\n=======');
    this.changeTitle(null);
  }

  public searchVerb(name: string): Observable<VerbDto> {
    //TODO: verification needs to be performed
    return this.api.doGetRequest(name)
      .pipe(
        tap((verb: VerbDto) => {
          this.changeTitle(verb.name);
        }),
      );
  }

  public changeTitle(verb: string): void {
    if (verb) {
      this.titleService.setTitle(`Conjuguer «${verb}»`);
    } else {
      // Null for param ${verb} indicates the initial page load
      this.titleService.setTitle('Le Conjuguer');
    }
  }
}
