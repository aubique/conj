import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full',
  }, {
    path: 'home',
    loadChildren: () =>
      import('./feature/home/home.module').then(m => m.HomeModule),
  }, {
    path: ':name',
    loadChildren: () =>
      import('./feature/table/table.module').then(m => m.TableModule),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
