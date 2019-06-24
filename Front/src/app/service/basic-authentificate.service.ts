import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
import {map} from 'rxjs/operators';
import { API_URL } from '../app-constants';
import { SelectorListContext } from '@angular/compiler';
import { PubliqueService } from './data/publique.service';
import { AdminService } from './data/admin.service';

export const TOKEN = 'token'
export const AUTHENTICATED_USER = 'authenticaterUser'
export const AUTHENTICATED_ROLE = 'authenticaterRole'

export class AuthentificationBasic{ 
  constructor(public message:string) { } 
} 

@Injectable({
  providedIn: 'root'
})
export class BasicAuthentificateService {

  constructor(
    private http: HttpClient,
    private publique: PubliqueService,
    private admin: AdminService
    ) { }

  public exeAuthServ(username, password) {
    return this.http.post<any>(
      `${API_URL}/authenticate`,{
        username,
        password
      }).pipe(
        map(
          data => {
            console.log(data);
            sessionStorage.setItem(AUTHENTICATED_USER, username);
            this.admin.getIdAdmin(username).subscribe(
              data => {
                let test = data;
                if(test != null){
                  sessionStorage.setItem(AUTHENTICATED_ROLE, "admin");
                } else {
                  sessionStorage.setItem(AUTHENTICATED_ROLE, "user");
                }
              }
            );
            sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
            return data;
        }
      )
    );
  }

  public getAuthenticatedRole() { 
    return sessionStorage.getItem('authenticaterRole') 
  }

  public getAuthenticatedUser() { 
    return sessionStorage.getItem('authenticaterUser') 
  }

  public getAuthenticatedToken() { 
    if(this.getAuthenticatedUser()) 
    return sessionStorage.getItem('token') 
  } 

  public isUserLoggedIn() { 
    let user = sessionStorage.getItem('authenticaterUser') 
    return !(user === null) 
  }
      
  public logout(){  
    sessionStorage.removeItem('authenticaterUser')
    sessionStorage.removeItem('authenticaterRole')
    sessionStorage.removeItem('token')
  } 
}
