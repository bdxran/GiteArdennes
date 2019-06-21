import { Component, OnInit } from '@angular/core';
import { BasicAuthentificateService } from 'src/app/service/basic-authentificate.service';
import { BasicInscriptionService } from 'src/app/service/basic-inscription.service';
import { Router } from '@angular/router';
import { Admins } from 'src/app/service/data/admin.service';
import { PubliqueService, Publiques } from 'src/app/service/data/publique.service';
import { VALID_ELEMENTS } from '@angular/core/src/sanitization/html_sanitizer';
import { Villes } from 'src/app/service/data/ville.service';

@Component({
  selector: 'app-create-compte',
  templateUrl: './create-compte.component.html',
  styleUrls: ['./create-compte.component.css']
})
export class CreateCompteComponent implements OnInit {

  private admin;
  private publique;
  private ville;
  private username: string;
  private password: string;
  private nom;
  private prenom;
  private adresse1;
  private adresse2;
  private adresse3;
  private telephone;
  private numCompte;
  private blacklist = false;
  private confirmPassword: string;
  private invalidPassword: boolean = false;

  constructor(private basicInscript: BasicInscriptionService,
    private basicAuth: BasicAuthentificateService,
    private publiqueService: PubliqueService,
    private router: Router) { }

  ngOnInit() {
  }

  public basicInscrip() {
    if(this.password == this.confirmPassword) {
      this.invalidPassword = false;

      this.ville = new Villes(1);

      this.publique = new Publiques(0,this.ville,this.nom,this.prenom,this.password,this.adresse1,this.adresse2,this.adresse3,this.telephone,this.username,this.numCompte,this.blacklist);

       this.publiqueService.newPublique(this.publique).subscribe(
        data => { 
          console.log(data);
        },
        error => {
          console.log(error);
        }
      );
    } else {
      return this.invalidPassword = true;
    }
  }

}
