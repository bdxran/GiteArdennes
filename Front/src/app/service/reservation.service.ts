import { Injectable } from '@angular/core';
import { API_URL } from '../app-constants';
import { HttpClient } from '@angular/common/http';
import { Admins } from './admin.service';
import { Publiques } from './publique.service';
import { Gites } from './gite.service';

export class Reservations {
  private idReservation;
  private idAdmin: Admins;
  private idPublique: Publiques;
  private idGite: Gites;
  private dateDebut: Date;
  private dateFin: Date;
  private communication: string;
  private statut: string;
  private total: number;

  public constructor(idReservation, idAdmin, idPublique, idGite, dateDebut, dateFin, communication, statut, total) {
    this.idReservation = idReservation;
    this.idAdmin = idAdmin;
    this.idPublique = idPublique;
    this.idGite = idGite;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.communication = communication;
    this.statut = statut;
    this.total = total;
  }
}

export class ReservationsAdmin {
  private idAdmin: Admins;
  private idGite: Gites;
  private dateDebut: Date;
  private dateFin: Date;
  private communication: string;
  private statut: string;
  private total: number;

  public constructor( idAdmin, idGite, dateDebut, dateFin, communication, statut, total) {
    this.idAdmin = new Admins(idAdmin);
    this.idGite = new Gites(idGite);
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.communication = communication;
    this.statut = statut;
    this.total = total;
  }
}

export class ReservationsPublique {
  private idPublique: Publiques;
  private idGite: Gites;
  private dateDebut: Date;
  private dateFin: Date;
  private communication: string;
  private statut: string;
  private total: number;

  public constructor(idPublique, idGite, dateDebut, dateFin, communication, statut, total) {
    this.idPublique = new Publiques(idPublique);
    this.idGite = new Gites(idGite);
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.communication = communication;
    this.statut = statut;
    this.total = total;
  }
}

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(
    private http: HttpClient
  ) { }

  public getReservations() {
    return this.http.get(`${API_URL}/reservations`);
  }

  public getReservationById(id) {
    return this.http.get(`${API_URL}/reservations/id/`+id);
  }

  public newReservation(reservation) {
    reservation = JSON.stringify(reservation);
    return this.http.post<any>(`${API_URL}/reservations`,reservation);
  }

  public updateReservation(reservation) {
    reservation = JSON.stringify(reservation);
    return this.http.post<any>(`${API_URL}/reservations`,reservation);
  }

  public deleteReservation(id){
    return this.http.delete(`${API_URL}/reservations/`+id);
  }
}
