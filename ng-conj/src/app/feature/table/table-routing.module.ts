import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TableResolver } from 'app/feature/table/table.resolver';
import { TableComponent } from './table.component';


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
