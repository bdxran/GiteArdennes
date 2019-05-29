import { Injectable } from '@angular/core';
import { API_URL } from '../app-constants';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Admins } from './admin.service';

export class Gites {
  private idGite: number;
  private idAdmin: Admins;
  private nom: string;
  private adresse1: string;
  private adresse2: string;
  private description: string;
  
  constructor(idGite?,admin?,nom?,adresse1?,adresse2?,description?) {
    this.idGite = idGite;
    this.idAdmin = new Admins(admin);
    this.nom = nom;
    this.adresse1 = adresse1;
    this.adresse2 = adresse2;
    this.description = description;
  }
}

@Injectable({
  providedIn: 'root'
})
export class GiteService {

  constructor(private http: HttpClient,
    private route: Router) { }

  public executeDataGiteService(){
     return this.http.get(`${API_URL}/gites`);
  }

  public newGite(gite){
    gite=JSON.stringify(gite)
    return this.http.post<any>(
      `${API_URL}/gites`,gite);
    // this.route.navigate(['/administration']);
 }
}
