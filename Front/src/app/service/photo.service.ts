import { Injectable } from '@angular/core';
import { API_URL } from '../app-constants';
import { HttpClient } from '@angular/common/http';

export class Photos {
  private idPhoto;
  private idGite;
  private lien;

  constructor(idPhoto, idGite, lien) {
    this.idPhoto = idPhoto;
    this.idGite = idGite;
    this.lien = lien;
  }
}

@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  constructor(private http: HttpClient) { }

  public getPhotos(){
    return this.http.get(`${API_URL}/photos`);
  }

  public getPhotosByIdGite(id){
    return this.http.get(`${API_URL}/photos/idGite/`+id);
  }
}
