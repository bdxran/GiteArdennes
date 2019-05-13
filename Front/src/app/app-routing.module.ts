import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { LogoutComponent } from './logout/logout.component';
import { AdministrationComponent } from './administration/administration.component';
import { GiteComponent } from './gite/gite.component';
import { NewGiteComponent } from './new-gite/new-gite.component';

const routes: Routes = [
  {path:"", component:WelcomeComponent},
  {path:"welcome", component:WelcomeComponent},
  {path:"welcome/:username", component:WelcomeComponent},
  {path:"signin", component:SigninComponent},
  {path:"signup", component:SignupComponent},
  {path:"logout", component:LogoutComponent},
  {path:"administration", component:AdministrationComponent},
  {path:"gite", component:GiteComponent},
  {path:"newGite", component:NewGiteComponent},
  {path:"**", component:ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
