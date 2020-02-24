import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CoreModule } from '@app/core.module';
import { SharedModule } from '@shared/shared.module';
import { HomeModule } from 'app/feature/home/home.module';
import { TableModule } from 'app/feature/table/table.module';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

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
