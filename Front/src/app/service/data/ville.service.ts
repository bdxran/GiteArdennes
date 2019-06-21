import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_URL } from '../../app-constants';

export class Villes{
  private idVille;
  private code;
  private codePostal;
  private nom;

  constructor(idVille?,code?,codePostal?,nom?){
    this.idVille = idVille;
    this.code = code;
    this.codePostal = codePostal;
    this.nom = nom;
  }
}

@Injectable({
  providedIn: 'root'
})
export class VilleService {

  constructor(
    private http: HttpClient,
  ) { }

  public getVilles() {
    return this.http.get(`${API_URL}/villes`);
  }

  public getVilleById(id) {
    return this.http.get(`${API_URL}/villes/id/`+id);
  }

  public newVille(ville){
    ville = JSON.stringify(ville);
    return this.http.post<any>(`${API_URL}/villes`,ville);
  }

  public updateVille(ville){
    ville = JSON.stringify(ville);
    return this.http.put(`${API_URL}/villes`,ville);
  }
}
