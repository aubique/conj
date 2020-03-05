import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { TenseListComponent } from 'app/feature/table/tense-list/tense-list.component';
import { GroupTabComponent } from './group-tab/group-tab.component';

import { TableRoutingModule } from './table-routing.module';
import { TableComponent } from './table.component';
import { VerbTabComponent } from './verb-tab/verb-tab.component';


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
