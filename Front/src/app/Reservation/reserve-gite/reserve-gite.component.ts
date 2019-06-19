import { Component, OnInit } from '@angular/core';
import { GiteService, Gites } from 'src/app/service/gite.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PhotoService } from 'src/app/service/photo.service';
import { NgbDateParserFormatter, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { BasicAuthentificateService } from 'src/app/service/basic-authentificate.service';
import { ReservationService, ReservationsPublique, ReservationsAdmin } from 'src/app/service/reservation.service';
import { AdminService, Admins } from 'src/app/service/admin.service';
import { PubliqueService, Publiques } from 'src/app/service/publique.service';

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

  constructor(private giteService: GiteService,
    private photoService: PhotoService,
    private reservationService: ReservationService,
    private publiqueService: PubliqueService,
    private adminService: AdminService,
    private router: ActivatedRoute,
    private route: Router,
    private parserFormatter: NgbDateParserFormatter,
    private basicAuthenticationService: BasicAuthentificateService
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
    let idGite = this.id;
    let dateDebut = this.parserFormatter.format(this.modelDebut);
    let datefin = this.parserFormatter.format(this.modelFin);
    let statut = "reserver";
    let total = 500;    //TO DO doit être auto générer suivant les dates et la saison
    let communication = "01-56459-21";    //TO DO doit être auto générer
    let username = this.basicAuthenticationService.getAuthenticatedUser();

    this.publiqueService.getIdPublique(username).subscribe(
      publiqueReponse => {
        let idPublique = publiqueReponse;

        let reservation = new ReservationsPublique(idPublique,idGite,dateDebut,datefin,communication,statut,total);

        this.reservationService.newReservation(reservation).subscribe(
          reservationReponse => {
            console.log(reservationReponse);
            this.route.navigate(["welcome"]);
          }
        );
      },
      error => {
        this.adminService.getIdAdmin(username).subscribe(
          adminReponse => {
            let idAdmin = adminReponse;
    
            let reservation = new ReservationsAdmin(idAdmin,idGite,dateDebut,datefin,communication,statut,total);
    
            this.reservationService.newReservation(reservation).subscribe(
              reservationReponse => {
                console.log(reservationReponse);
                this.route.navigate(["welcome"]);
              }
            );
          }
        );
      }
    );
  }
  
}
