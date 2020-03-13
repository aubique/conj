import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from '@modules/home/home.component';
import { HomeResolver } from '@modules/home/home.resolver';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    resolve: {
      project: HomeResolver,
    },
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class HomeRoutingModule {
}
