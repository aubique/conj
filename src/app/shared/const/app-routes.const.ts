import { Routes } from '@angular/router';

export const AppRoutes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full',
  },
  {
    path: 'home',
    loadChildren: () =>
      import('../../features/home/home.module').then((m) => m.HomeModule),
  },
  {
    path: ':name',
    loadChildren: () =>
      import('../../features/table/table.module').then((m) => m.TableModule),
  },
];
