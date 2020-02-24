import { CommonModule } from '@angular/common';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NgModule, Optional, Provider, SkipSelf } from '@angular/core';
import { throwIfAlreadyLoaded } from '@app/guards/module-import.guard';
import { ErrorInterceptor } from '@app/http/error.interceptor';

const ERROR_INTERCEPTOR: Provider = {
  provide: HTTP_INTERCEPTORS,
  useClass: ErrorInterceptor,
  multi: true,
};

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule,
  ],
  providers: [ERROR_INTERCEPTOR],
})
export class CoreModule {

  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    throwIfAlreadyLoaded(parentModule, 'Core Module');
  }
}
