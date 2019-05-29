import { Injectable } from '@angular/core';
import { API_URL } from '../app-constants';
import { HttpClient } from '@angular/common/http';

export class Photos {
  constructor() {

  }
}

@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  constructor(private http: HttpClient) { }

  public executeDataPhotoService(){
    return this.http.get(`${API_URL}/photos`);
  }
}
