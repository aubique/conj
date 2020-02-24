import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { CardComponent } from './card/card.component';

import { TableRoutingModule } from './table-routing.module';
import { TableComponent } from './table.component';


@NgModule({
  declarations: [
    TableComponent,
    CardComponent,
  ],
  imports: [
    CommonModule,
    TableRoutingModule,
    SharedModule,
  ],
  exports: [],
})
export class TableModule {
}
