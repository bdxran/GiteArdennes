import { Injectable } from '@angular/core';
import { API_URL } from '../../app-constants';
import { HttpClient } from '@angular/common/http';

export class Pays{
  private code;
  private nom;

  public constructor(code?, nom?){
    this.code = code;
    this.nom = nom;
  }
}

@Injectable({
  providedIn: 'root'
})
export class PaysService {

  constructor(
    private http:HttpClient
  ) { }

  public getPays() {
    return this.http.get(`${API_URL}/pays`);
  }

  public getPaysById(id) {
    return this.http.get(`${API_URL}/pays/id/`+id);
  }

  public getPaysByName(name) {
    return this.http.get(`${API_URL}/pays/`+name);
  }

  public newPays(pays) {
    pays = JSON.stringify(pays);
    return this.http.post<any>(`${API_URL}/pays`,pays);
  }

  public updatePays(pays) {
    pays = JSON.stringify(pays);
    return this.http.put(`${API_URL}/pays`,pays);
  }
}
