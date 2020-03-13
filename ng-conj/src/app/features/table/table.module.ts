import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { GroupTabComponent } from '@modules/table/group-tab/group-tab.component';
import { TableRoutingModule } from '@modules/table/table-routing.module';
import { TableComponent } from '@modules/table/table.component';
import { TenseListComponent } from '@modules/table/tense-list/tense-list.component';
import { VerbTabComponent } from '@modules/table/verb-tab/verb-tab.component';
import { SharedModule } from '@shared/shared.module';


@NgModule({
  declarations: [
    TableComponent,
    TenseListComponent,
    GroupTabComponent,
    VerbTabComponent,
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
