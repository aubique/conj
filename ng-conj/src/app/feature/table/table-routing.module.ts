import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TensesResolver } from 'app/feature/table/tenses-resolver.service';
import { TableComponent } from './table.component';


const routes: Routes = [
  {
    path: '',
    component: TableComponent,
    resolve: {
      verbResolved: TensesResolver,
    },
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TableRoutingModule {
}
