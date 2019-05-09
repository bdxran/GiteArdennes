import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import { BasicAuthentificateService } from './basic-authentificate.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorBasicAuthService implements HttpInterceptor {

  constructor(private basicAuthenticationService : BasicAuthentificateService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler){
    let basicAuthHeaderString = this.basicAuthenticationService.getAuthenticatedToken();
    let username = this.basicAuthenticationService.getAuthenticatedUser()
    let reqauth
    console.log(username)
    console.log(req)
    
    if(basicAuthHeaderString && username) { 
      console.log(basicAuthHeaderString)
      reqauth = req.clone({
           setHeaders : {
               "Authorization" : basicAuthHeaderString,
               "Content-Type" : "application/json"
             }
           })
      console.log('reqauth')    
      return next.handle(reqauth);
    }

    console.log('req')   
    return next.handle(req);
  }
}
