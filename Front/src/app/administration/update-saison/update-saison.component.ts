import { Component, OnInit } from '@angular/core';
import { SaisonService, Saisons } from 'src/app/service/data/saison.service';
import { Router, ActivatedRoute } from '@angular/router';
import { GiteService, Gites } from 'src/app/service/data/gite.service';
import { NgbDateStruct, NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-update-saison',
  templateUrl: './update-saison.component.html',
  styleUrls: ['./update-saison.component.css']
})
export class UpdateSaisonComponent implements OnInit {

  private id;
  private saison;
  private gite;
  private modelDebut: NgbDateStruct;
  private modelFin: NgbDateStruct;

  constructor(
    private saisonService: SaisonService,
    private giteService: GiteService,
    private route: Router,
    private parserFormatter: NgbDateParserFormatter,
    private router: ActivatedRoute
  ) { }

  ngOnInit() {
    this.id = this.router.snapshot.paramMap.get("id");

    this.saisonService.getSaisonsById(this.id).subscribe(
      data => {
        this.saison = data;
      }
    );
  }

  public updateSaison() {
    this.giteService.getGiteById(this.saison.idGite.idGite).subscribe(
      data => {
        this.gite = data; 

        this.gite = new Gites(this.gite.idGite);

        let dateDebut = this.parserFormatter.format(this.modelDebut);
        let dateFin = this.parserFormatter.format(this.modelFin);

        this.saison = new Saisons(this.id,this.gite,this.saison.nom,dateDebut,dateFin,this.saison.tarif)

        this.saisonService.updateSaisons(this.saison).subscribe(
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
