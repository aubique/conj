import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { TableComponent } from '@modules/table/table.component';
import { TableResolver } from '@modules/table/table.resolver';


const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: TableComponent,
    resolve: {
      verbResolved: TableResolver,
    },
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TableRoutingModule {
}
