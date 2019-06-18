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
import { SigninComponent } from './signin/signin.component';
import { HttpInterceptorBasicAuthService } from './service/http-interceptor-basic-auth.service';
import { SignupComponent } from './signup/signup.component';
import { LogoutComponent } from './logout/logout.component';
import { AdministrationComponent } from './administration/administration.component';
import { GiteComponent } from './gite/gite.component';
import { NewGiteComponent } from './new-gite/new-gite.component';
import { CallBackPipe } from './pipe/call-back.pipe';

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
    AdministrationComponent,
    GiteComponent,
    NewGiteComponent,
    CallBackPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
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
