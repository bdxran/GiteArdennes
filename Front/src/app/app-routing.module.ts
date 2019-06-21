import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { SigninComponent } from './Compte/signin/signin.component';
import { SignupComponent } from './Compte/signup/signup.component';
import { LogoutComponent } from './Compte/logout/logout.component';
import { GiteComponent } from './Gites/gite/gite.component';
import { NewGiteComponent } from './Gites/new-gite/new-gite.component';
import { RouteGuardService } from './service/data/route-guard.service';
import { UpdateGiteComponent } from './Gites/update-gite/update-gite.component';
import { ViewGiteComponent } from './Gites/view-gite/view-gite.component';
import { ReserveGiteComponent } from './Reservation/reserve-gite/reserve-gite.component';
import { ReservationComponent } from './Reservation/reservation/reservation.component';
import { CreateCompteComponent } from './Compte/create-compte/create-compte.component';
import { UserComponent } from './Compte/user/user.component';
import { VilleComponent } from './administration/ville/ville.component';
import { PaysComponent } from './administration/pays/pays.component';
import { UpdateVilleComponent } from './administration/update-ville/update-ville.component';
import { UpdatePaysComponent } from './administration/update-pays/update-pays.component';
import { NewVilleComponent } from './administration/new-ville/new-ville.component';
import { NewPaysComponent } from './administration/new-pays/new-pays.component';
import { SaisonComponent } from './administration/saison/saison.component';
import { NewSaisonComponent } from './administration/new-saison/new-saison.component';
import { UpdateSaisonComponent } from './administration/update-saison/update-saison.component';
import { LogComponent } from './administration/log/log.component';

const routes: Routes = [
  {path:"", component:WelcomeComponent},
  {path:"welcome", component:WelcomeComponent},
  {path:"welcome/:username", component:WelcomeComponent, canActivate:[RouteGuardService]},
  {path:"signin", component:SigninComponent},
  {path:"createCompte", component:CreateCompteComponent},
  {path:"signup", component:SignupComponent, canActivate:[RouteGuardService]},
  {path:"logout", component:LogoutComponent},
  {path:"gite", component:GiteComponent, canActivate:[RouteGuardService]},
  {path:"addGite", component:NewGiteComponent, canActivate:[RouteGuardService]},
  {path:"updateGite/:id", component:UpdateGiteComponent, canActivate:[RouteGuardService]},
  {path:"viewGite/:id", component:ViewGiteComponent, canActivate:[RouteGuardService]},
  {path:"reservation", component:ReservationComponent, canActivate:[RouteGuardService]},
  {path:"reserveGite/:id", component:ReserveGiteComponent, canActivate:[RouteGuardService]},
  {path:"user", component:UserComponent, canActivate:[RouteGuardService]},
  {path:"ville", component:VilleComponent, canActivate:[RouteGuardService]},
  {path:"newVille", component:NewVilleComponent, canActivate:[RouteGuardService]},
  {path:"updateVille/:id", component:UpdateVilleComponent, canActivate:[RouteGuardService]},
  {path:"pays", component:PaysComponent, canActivate:[RouteGuardService]},
  {path:"newPays", component:NewPaysComponent, canActivate:[RouteGuardService]},
  {path:"updatePays/:id", component:UpdatePaysComponent, canActivate:[RouteGuardService]},
  {path:"saison", component:SaisonComponent, canActivate:[RouteGuardService]},
  {path:"newSaison", component:NewSaisonComponent, canActivate:[RouteGuardService]},
  {path:"updateSaison/:id", component:UpdateSaisonComponent, canActivate:[RouteGuardService]},
  {path:"log", component:LogComponent, canActivate:[RouteGuardService]},
  {path:"**", component:ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
