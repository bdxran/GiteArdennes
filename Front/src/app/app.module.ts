import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SigninComponent } from './Compte/signin/signin.component';
import { HttpInterceptorBasicAuthService } from './service/http-interceptor-basic-auth.service';
import { SignupComponent } from './Compte/signup/signup.component';
import { LogoutComponent } from './Compte/logout/logout.component';
import { GiteComponent } from './Gites/gite/gite.component';
import { NewGiteComponent } from './Gites/new-gite/new-gite.component';
import { CallBackPipe } from './pipe/call-back.pipe';
import { UpdateGiteComponent } from './Gites/update-gite/update-gite.component';
import { ViewGiteComponent } from './Gites/view-gite/view-gite.component';
import { ReserveGiteComponent } from './Reservation/reserve-gite/reserve-gite.component';
import { HttpModule} from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
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
import { UpdateSaisonComponent } from './administration/update-saison/update-saison.component';
import { NewSaisonComponent } from './administration/new-saison/new-saison.component';
import { LogComponent } from './administration/log/log.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    ErrorComponent,
    HeaderComponent,
    FooterComponent,
    SigninComponent,
    SignupComponent,
    LogoutComponent,
    GiteComponent,
    NewGiteComponent,
    CallBackPipe,
    UpdateGiteComponent,
    ViewGiteComponent,
    ReserveGiteComponent,
    ReservationComponent,
    CreateCompteComponent,
    UserComponent,
    VilleComponent,
    PaysComponent,
    UpdateVilleComponent,
    UpdatePaysComponent,
    NewVilleComponent,
    NewPaysComponent,
    SaisonComponent,
    UpdateSaisonComponent,
    NewSaisonComponent,
    LogComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    HttpModule,
  ],
  providers: [
    {
    provide: HTTP_INTERCEPTORS,
    useClass: HttpInterceptorBasicAuthService,
    multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
export class NgbdDatepickerBasicModule { }