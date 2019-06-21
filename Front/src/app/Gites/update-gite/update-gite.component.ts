import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { BasicAuthentificateService } from '../../service/basic-authentificate.service';
import { AdminService, Admins } from '../../service/data/admin.service';
import { GiteService, Gites } from '../../service/data/gite.service';

@Component({
  selector: 'app-update-gite',
  templateUrl: './update-gite.component.html',
  styleUrls: ['./update-gite.component.css']
})
export class UpdateGiteComponent implements OnInit {

  private id;
  private gite;
  private admin;
  private nom: string;
  private adresse1: string;
  private adresse2: string;
  private description: string;

  constructor(private giteService: GiteService,
    private adminService: AdminService,
    private basicAuthenticationService: BasicAuthentificateService,
    private router: ActivatedRoute,
    private route: Router
    ) { }

  ngOnInit() {
    this.id = this.router.snapshot.paramMap.get("id");

    console.log(this.id)

    this.giteService.getGiteById(this.id).subscribe(
      data => { 
        this.gite = data;
        this.nom = this.gite.nom;
        this.adresse1 = this.gite.adresse1;
        this.adresse2 = this.gite.adresse2;
        this.description = this.gite.description;
      },
      error => {
        console.log(error);
      }
    );
  }

  public updateGite() {

    let username = this.basicAuthenticationService.getAuthenticatedUser();

    this.adminService.getIdAdmin(username).subscribe(
      adminReponse => {
        this.admin = adminReponse;

        this.admin = new Admins(this.admin.idAdmin);

        this.gite = new Gites(this.id,this.admin,this.nom,this.adresse1,this.adresse2,this.description);

        this.giteService.updateGite(this.gite).subscribe(
          data => { 
            console.log(data);
            this.route.navigate(['/gite']);
          },
          error => {
            console.log(error);
          }
        );
      }
    );
  }

  public navigate(direction){
    this.route.navigate([direction]);
  }
}
