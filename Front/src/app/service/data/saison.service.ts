import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_URL } from 'src/app/app-constants';

export class Saisons{
  private idSaison;
  private idGite;
  private nom;
  private dateDebut;
  private dateFin;
  private tarif;

  public constructor(idSaison?,idGite?,nom?,dateDebut?,dateFin?,tarif?) {
    this.idSaison = idSaison;
    this.idGite = idGite;
    this.nom = nom;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.tarif = tarif;
  }
}

@Injectable({
  providedIn: 'root'
})
export class SaisonService {

  constructor(
    private http: HttpClient
  ) { }

  public getSaisons() {
    return this.http.get(`${API_URL}/saisons`);
  }

  public getSaisonsById(id) {
    return this.http.get(`${API_URL}/saisons/id/`+id);
  }

  public getSaisonsByName(name) {
    return this.http.get(`${API_URL}/saisons/name/`+name);
  }

  public getSaisonByDateDebut(date) {
    return this.http.get(`${API_URL}/saisons/dateDebut/`+date);
  }

  public getSaisonByDateFin(date) {
    return this.http.get(`${API_URL}/saisons/dateFin/`+date);
  }

  public newSaisons(saison) {
    saison = JSON.stringify(saison);
    return this.http.post<any>(`${API_URL}/saisons`,saison);
  }

  public updateSaisons(saison) {
    saison = JSON.stringify(saison);
    return this.http.put(`${API_URL}/saisons`,saison);
  }

  public deleteSaisons(id) {
    return this.http.delete(`${API_URL}/saisons/`+id);
  }
}
