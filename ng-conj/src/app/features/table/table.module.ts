import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TableRoutingModule } from './table-routing.module';
import { TableComponent } from './table.component';
import { CardComponent } from './card/card.component';
import { SharedModule } from '@shared/shared.module';


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
