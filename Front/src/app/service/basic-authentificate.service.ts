import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
import {map} from 'rxjs/operators';
import { API_URL } from '../app-constants';

export const TOKEN = 'token'
export const AUTHENTICATED_USER = 'authenticaterUser'

export class AuthentificationBasic{ 
  constructor(public message:string) { } 
} 

@Injectable({
  providedIn: 'root'
})
export class BasicAuthentificateService {

  constructor(private http: HttpClient) { }

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
            sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
            return data;
        }
      )
    );
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
    sessionStorage.removeItem('token')
  } 
}
