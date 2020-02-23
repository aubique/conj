import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TableModule } from './features/table/table.module';
import { CoreModule } from '@app/core.module';
import { HomeModule } from './features/home/home.module';
import { SharedModule } from '@shared/shared.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    // Angular
    BrowserModule,
    BrowserAnimationsModule,
    // Parent route
    AppRoutingModule,
    // Hot-loaded modules
    TableModule,
    HomeModule,
    // Core & Shared
    CoreModule,
    SharedModule,
  ],
  // entryComponents: [AppComponent], //TODO: be aware of changes
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {
}
