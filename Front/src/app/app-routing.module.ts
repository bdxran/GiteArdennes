import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { SigninComponent } from './signin/signin.component';

const routes: Routes = [
  {path:"", component:WelcomeComponent},
  {path:"welcome", component:WelcomeComponent},
  {path:"welcome/:username", component:WelcomeComponent},
  {path:"signin", component:SigninComponent},
  {path:"**", component:ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
