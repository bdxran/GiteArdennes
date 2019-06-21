import { Component, OnInit } from '@angular/core';
import { SaisonService, Saisons } from 'src/app/service/data/saison.service';
import { Router } from '@angular/router';
import { GiteService, Gites } from 'src/app/service/data/gite.service';
import { NgbDateStruct, NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-new-saison',
  templateUrl: './new-saison.component.html',
  styleUrls: ['./new-saison.component.css']
})
export class NewSaisonComponent implements OnInit {

  private saison;
  private gite;
  private nom;
  private nomGite;
  private tarif;
  private modelDebut: NgbDateStruct;
  private modelFin: NgbDateStruct;

  constructor(
    private saisonService: SaisonService,
    private giteService: GiteService,
    private parserFormatter: NgbDateParserFormatter,
    private route: Router
  ) { }

  ngOnInit() {
  }

  public newSaison() {
    this.giteService.getGiteByName(this.nomGite).subscribe(
      data => {
        this.gite = data;

        this.gite = new Gites(this.gite);

        let dateDebut = this.parserFormatter.format(this.modelDebut);
        let dateFin = this.parserFormatter.format(this.modelFin);

        this.saison = new Saisons("",this.gite,this.nom,dateDebut,dateFin,this.tarif);

        this.saisonService.newSaisons(this.saison).subscribe(
          data => {
            console.log(data);

            this.navigate("saison");
          }
        );
      }
    );
  }

  public navigate(direction) {
    this.route.navigate([direction]);
  }
}
