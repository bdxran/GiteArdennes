import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_URL } from '../../app-constants';

export class Publiques {
  private idPublique;
  private idVille;
  private nom;
  private prenom;
  private mdp;
  private adresse1;
  private adresse2;
  private adresse3;
  private telephone;
  private email;
  private numCompte;
  private blacklist

  public constructor(idPublique?,idVille?,nom?,prenom?,mdp?,adresse1?,adresse2?,adresse3?,telephone?,email?,numCompte?,blacklist?) {
    this.idPublique = idPublique;
    this.idVille = idVille;
    this.nom = nom;
    this.prenom = prenom;
    this.mdp = mdp;
    this.adresse1 = adresse1;
    this.adresse2 = adresse2;
    this.adresse3 = adresse3;
    this.telephone = telephone;
    this.email = email;
    this.numCompte = numCompte;
    this.blacklist = blacklist;
  }
}

@Injectable({
  providedIn: 'root'
})
export class PubliqueService {

  constructor(
    private http: HttpClient
  ) { }

  public getPubliques() {
    return this.http.get(`${API_URL}/publiques`);
  }

  public getPubliqueById(id) {
    return this.http.get(`${API_URL}/publiques/`+id);
  }

  public getIdPublique(username) {
    let email = this.stringSplit(username,0);
    let racine = this.stringSplit(username,1);
    return this.http.get(`${API_URL}/publiques/id`,{params:{email,racine}});
  }

  public newPublique(publique) {
    publique = JSON.stringify(publique);
    return this.http.post<any>(`${API_URL}/publiques`,publique);
  }

  public updatePublique(publique) {
    publique = JSON.stringify(publique);
    return this.http.put<any>(`${API_URL}/publiques`,publique);
  }

  public stringSplit(string,nb) {
    let array = string.split('.');
    return array[nb];
  }
}
