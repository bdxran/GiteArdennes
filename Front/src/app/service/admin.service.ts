import { Injectable } from '@angular/core';
import { API_URL } from '../app-constants';
import { HttpClient } from '@angular/common/http';

export class Admins {
  private idAdmin: number;
  private login: string;
  private mdp: string;
  
  constructor(idAdmin?, username?, password?) {
    this.idAdmin = idAdmin;
    this.login = username;
    this.mdp = password;
  }
}

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  public executeDataAdminService(){
    return this.http.get(`${API_URL}/admins`);
  }

  public getIdAdmin(username: string) {
    return this.http.get(`${API_URL}/admins/login`,{params: {username}});
  }
}
