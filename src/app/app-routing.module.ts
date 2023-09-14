import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./pages/home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'genres',
    loadChildren: () => import('./pages/genres/genres.module').then( m => m.GenresPageModule)
  },
  {
    path: 'genres/:id',
    loadChildren: () => import('./pages/genre/genre.module').then( m => m.GenrePageModule)
  },
  {
    path: 'countries',
    loadChildren: () => import('./pages/countries/countries.module').then( m => m.CountriesPageModule)
  },
  {
    path: 'countries/:code',
    loadChildren: () => import('./pages/country/country.module').then( m => m.CountryPageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
