import { Component, OnInit } from '@angular/core';
import { GiteService, Gites } from '../service/gite.service';
import { BasicAuthentificateService } from '../service/basic-authentificate.service';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-new-gite',
  templateUrl: './new-gite.component.html',
  styleUrls: ['./new-gite.component.css']
})
export class NewGiteComponent implements OnInit {

  private gite;
  private admin;
  private nom: string;
  private adresse1: string;
  private adresse2: string;
  private description: string;

  constructor(private giteService: GiteService,
    private adminService: AdminService,
    private basicAuthenticationService: BasicAuthentificateService
    ) { }

  ngOnInit() {
  }

  public addGite() {

    let username = this.basicAuthenticationService.getAuthenticatedUser();

    this.adminService.getIdAdmin(username).subscribe(
      adminReponse => {
        this.admin = adminReponse;
        console.log(adminReponse);

        this.gite = new Gites(this.admin,this.nom,this.adresse1,this.adresse2,this.description);

        this.giteService.newGite(this.gite).subscribe(
          data => { 
            console.log(data);
          },
          error => {
            console.log(error);
          }
        );
      }
    );
  }
}
