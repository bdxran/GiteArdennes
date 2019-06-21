import { Component, OnInit } from '@angular/core';
import { PubliqueService, Publiques } from 'src/app/service/data/publique.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  private user;
  private pub;

  constructor(
    private publiqueService: PubliqueService,
    private route: Router,
  ) { }

  ngOnInit() {
    this.publiqueService.getPubliques().subscribe(
      data => {
        this.user = data;
      }
    );
  }

  public update(id,statut) {
    this.publiqueService.getPubliqueById(id).subscribe(
      data => {
        this.pub = data;

        this.pub = new Publiques(id,this.pub.idVille,this.pub.nom,this.pub.prenom,this.pub.mdp,this.pub.adresse1,this.pub.adresse2,this.pub.adresse3,this.pub.telephone,this.pub.email,this.pub.numCompte,statut)

        this.publiqueService.updatePublique(this.pub).subscribe(
          data => {
            console.log(data);
            window.location.reload();
          }
        );
      }
    );
  }

}
