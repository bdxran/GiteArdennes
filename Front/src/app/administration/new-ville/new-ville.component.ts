import { Component, OnInit } from '@angular/core';
import { Pays, PaysService } from 'src/app/service/data/pays.service';
import { VilleService, Villes } from 'src/app/service/data/ville.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-ville',
  templateUrl: './new-ville.component.html',
  styleUrls: ['./new-ville.component.css']
})
export class NewVilleComponent implements OnInit {

  private ville;
  private pays;
  private nomPays;
  private nom;
  private codePostal;

  constructor(
    private villeService: VilleService,
    private paysService: PaysService,
    private route: Router,
  ) { }

  ngOnInit() {
  }

  public newVille() {
    this.paysService.getPaysByName(this.nomPays).subscribe(
      data => {
        console.log(data)
        this.pays = data; 

        this.pays = new Pays(this.pays.code);

        this.ville = new Villes("",this.pays,this.codePostal,this.nom)

        this.villeService.newVille(this.ville).subscribe(
          data => {
            console.log(data);
            this.navigate("ville");
          }
        );
      }
    );
  }

  public navigate(direction) {
    this.route.navigate([direction]);
  }
}
