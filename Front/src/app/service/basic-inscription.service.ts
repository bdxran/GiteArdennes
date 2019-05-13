import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
import { API_URL } from '../app-constants';

@Injectable({
  providedIn: 'root'
})
export class BasicInscriptionService {

  constructor(private http: HttpClient) { }

  public exeInscripServ(admin) {
    admin=JSON.stringify(admin)
      return this.http.post<any>(
      `${API_URL}/admins`,admin);
  }
}
