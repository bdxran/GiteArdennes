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
import { RouteGuardService } from './service/route-guard.service';

const routes: Routes = [
  {path:"", component:WelcomeComponent, canActivate:[RouteGuardService]},
  {path:"welcome", component:WelcomeComponent, canActivate:[RouteGuardService]},
  {path:"welcome/:username", component:WelcomeComponent, canActivate:[RouteGuardService]},
  {path:"signin", component:SigninComponent},
  {path:"signup", component:SignupComponent, canActivate:[RouteGuardService]},
  {path:"logout", component:LogoutComponent},
  {path:"administration", component:AdministrationComponent, canActivate:[RouteGuardService]},
  {path:"gite", component:GiteComponent, canActivate:[RouteGuardService]},
  {path:"newGite", component:NewGiteComponent, canActivate:[RouteGuardService]},
  {path:"**", component:ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
