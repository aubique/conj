import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeResolver } from 'app/feature/home/home.resolver';
import { HomeComponent } from './home.component';


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
