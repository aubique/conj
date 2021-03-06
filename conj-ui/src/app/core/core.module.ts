import { CommonModule } from '@angular/common';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NgModule, Optional, Provider, SkipSelf } from '@angular/core';

import { FooterComponent } from '@app/components/footer/footer.component';
import { HeaderComponent } from '@app/components/header/header.component';
import { throwIfAlreadyLoaded } from '@app/guards/module-import.guard';
import { ErrorInterceptor } from '@app/http/error.interceptor';
import { RouteHandlerService } from '@app/services/route-handler.service';
import { SharedModule } from '@shared/shared.module';


const ERROR_INTERCEPTOR: Provider = {
  provide: HTTP_INTERCEPTORS,
  useClass: ErrorInterceptor,
  multi: true,
};

@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
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
  ],
})
export class CoreModule {

  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    throwIfAlreadyLoaded(parentModule, 'Core Module');
  }
}
