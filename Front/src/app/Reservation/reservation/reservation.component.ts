import { Component, OnInit } from '@angular/core';
import { ReservationService, Reservations} from 'src/app/service/data/reservation.service';
import { GiteService } from 'src/app/service/data/gite.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {

  private reservation;
  private reserve;
  private gite;
  private nom= "test";

  constructor(
    private reservationService: ReservationService,
    private giteService: GiteService
  ) { }

  ngOnInit() {
    this.reservationService.getReservations().subscribe(
      reservationReponse => {
        this.reservation = reservationReponse;
      }
    );
  }

  public getNameGite(id) {
    this.giteService.getGiteById(id).subscribe(
      giteReponse => {
        this.gite = giteReponse;
        this.nom = this.gite.nom;
      }
    );
  }

  public update(id, statut){
    this.reservationService.getReservationById(id).subscribe(
      data => {
        this.reserve = data;

        this.reserve = new Reservations(id,this.reserve.idAdmin,this.reserve.idPublique,this.reserve.idGite,this.reserve.dateDebut,this.reserve.dateFin,this.reserve.communication,statut,this.reserve.total);

        this.reservationService.updateReservation(this.reserve).subscribe();
        window.location.reload();
      }
    );
    
  }

  public delete(id) {
    this.reservationService.deleteReservation(id).subscribe();
    window.location.reload();
  }
}
