import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { CoreModule } from '@app/core.module';
import { HomeModule } from '@modules/home/home.module';
import { TableModule } from '@modules/table/table.module';
import { SharedModule } from '@shared/shared.module';
import { AppRoutingModule } from 'app/app-routing.module';
import { AppComponent } from 'app/app.component';


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
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {
}
