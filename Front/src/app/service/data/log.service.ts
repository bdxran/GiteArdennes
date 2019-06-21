import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_URL } from 'src/app/app-constants';

@Injectable({
  providedIn: 'root'
})
export class LogService {

  constructor(
    private http: HttpClient
  ) { }

  public getLogs() {
    return this.http.get(`${API_URL}/logs`);
  }

  public getLogsByDate(date) {
    return this.http.get(`${API_URL}/logs/`+date);
  }
}
