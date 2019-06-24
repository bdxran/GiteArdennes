import { Component, OnInit } from '@angular/core';
import { GiteService, Gites } from 'src/app/service/data/gite.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PhotoService } from 'src/app/service/data/photo.service';
import { NgbDateParserFormatter, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { BasicAuthentificateService } from 'src/app/service/basic-authentificate.service';
import { ReservationService, Reservations, ReservationsPublique, ReservationsAdmin } from 'src/app/service/data/reservation.service';
import { AdminService, Admins } from 'src/app/service/data/admin.service';
import { PubliqueService, Publiques } from 'src/app/service/data/publique.service';
import { transitiveScopesFor } from '@angular/core/src/render3/jit/module';
import { SaisonService } from 'src/app/service/data/saison.service';

@Component({
  selector: 'app-reserve-gite',
  templateUrl: './reserve-gite.component.html',
  styleUrls: ['./reserve-gite.component.css']
})
export class ReserveGiteComponent implements OnInit {

  private id;
  private gite;
  private source;
  private nom: string = "";
  private adresse1: string = "";
  private adresse2: string = "";
  private description: string = "";
  private modelDebut: NgbDateStruct;
  private modelFin: NgbDateStruct;
  private saisonDebut;
  private saisonFin;

  constructor(private giteService: GiteService,
    private photoService: PhotoService,
    private reservationService: ReservationService,
    private publiqueService: PubliqueService,
    private adminService: AdminService,
    private router: ActivatedRoute,
    private route: Router,
    private parserFormatter: NgbDateParserFormatter,
    private basicAuthenticationService: BasicAuthentificateService,
    private saisonService: SaisonService
    ) { }

  ngOnInit() {
    this.id = this.router.snapshot.paramMap.get("id");

    this.giteService.getGiteById(this.id).subscribe(
      data => { 
        this.gite = data;
        this.nom = this.gite.nom;
        this.adresse1 = this.gite.adresse1;
        this.adresse2 = this.gite.adresse2;
        this.description = this.gite.description;

        this.photoService.getPhotosByIdGite(this.id).subscribe(
          photoReponse => {
            this.source = photoReponse;
          }
        )
      },
      error => {
        console.log(error);
      }
    );
  }

  public navigate(direction) {
    this.route.navigate([direction]);
  }

  public reserve(){
    let idGite = new Gites(this.id);
    let dateDebut = this.parserFormatter.format(this.modelDebut);
    let dateFin = this.parserFormatter.format(this.modelFin);
    let statut = "Reserved";
    let total = 500;//this.getPrix(dateDebut,dateFin);    //N'est pas fonctionnel
    let communication = "01-56459-21";    //TO DO doit être auto générer
    let username = this.basicAuthenticationService.getAuthenticatedUser();
    let role = this.basicAuthenticationService.getAuthenticatedRole();

    if(role == 'user') {
      this.publiqueService.getIdPublique(username).subscribe(
        publiqueReponse => {
          let idPublique = publiqueReponse;
  
          let reservation = new ReservationsPublique(idPublique,idGite,dateDebut,dateFin,communication,statut,total);
  
          this.reservationService.newReservation(reservation).subscribe(
            reservationReponse => {
              console.log(reservationReponse);
              this.route.navigate(["welcome"]);
            }
          );
        }
      );
    } else {
      this.adminService.getIdAdmin(username).subscribe(
        adminReponse => {
          let idAdmin = adminReponse;

          idAdmin = new Admins(idAdmin);
    
          let reservation = new ReservationsAdmin(idAdmin,idGite,dateDebut,dateFin,communication,statut,total);
    
          this.reservationService.newReservation(reservation).subscribe(
            reservationReponse => {
              console.log(reservationReponse);
              this.route.navigate(["welcome"]);
            }
          );
        }
      );
    }
  }

  public getPrix(dateDebut,dateFin) {   //N'est pas fonctionnel
    this.saisonService.getSaisonByDateDebut(dateDebut).subscribe(
      data => {
        this.saisonDebut = data;

        this.saisonService.getSaisonByDateFin(dateFin).subscribe(
          data => {
            this.saisonFin = data;
            
            if(this.saisonDebut.idSaison == this.saisonFin.idSaison){
              let time = dateFin - dateDebut;
              let nbJour = time * 86400000;

              let prix = nbJour * this.saisonDebut.tarif;

              return prix;
            } else {
              let time1 = this.saisonDebut.dateFin - dateDebut;
              let time2 = dateFin - this.saisonFin.dateDebut;
              let nbJour = (time1 + time2) * 86400000;
              let prix = nbJour * this.saisonDebut.tarif;

              return prix;
            }
          }
        );
      }
    );
  }
  
}
