import { CommonModule } from '@angular/common';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NgModule, Optional, Provider, SkipSelf } from '@angular/core';
import { throwIfAlreadyLoaded } from '@app/guards/module-import.guard';
import { ErrorInterceptor } from '@app/http/error.interceptor';
import { RouteHandlerService } from '@app/services/route-handler.service';
import { SharedModule } from '@shared/shared.module';
import { SearchComponent } from 'app/core/components/search/search.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { HintComponent } from './components/hint/hint.component';

const ERROR_INTERCEPTOR: Provider = {
  provide: HTTP_INTERCEPTORS,
  useClass: ErrorInterceptor,
  multi: true,
};

@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    SearchComponent,
    HintComponent,
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    SharedModule,
  ],
  providers: [
    ERROR_INTERCEPTOR,
    RouteHandlerService,
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    SearchComponent,
    HintComponent,
  ],
})
export class CoreModule {

  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    throwIfAlreadyLoaded(parentModule, 'Core Module');
  }
}
