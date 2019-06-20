import { Injectable } from '@angular/core';
import { API_URL } from '../app-constants';
import { HttpClient } from '@angular/common/http';

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
}
