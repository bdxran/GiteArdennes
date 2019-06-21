import { Component, OnInit } from '@angular/core';
import { VilleService, Villes } from 'src/app/service/data/ville.service';
import { PaysService, Pays } from 'src/app/service/data/pays.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-ville',
  templateUrl: './update-ville.component.html',
  styleUrls: ['./update-ville.component.css']
})
export class UpdateVilleComponent implements OnInit {

  private id;
  private ville;
  private pays;

  constructor(
    private villeService: VilleService,
    private paysService: PaysService,
    private route: Router,
    private router: ActivatedRoute
  ) { }

  ngOnInit() {
    this.id = this.router.snapshot.paramMap.get("id");

    this.villeService.getVilleById(this.id).subscribe(
      data => {
        this.ville = data;
      }
    );
  }

  public updateVille() {
    this.paysService.getPaysByName(this.ville.code.nom).subscribe(
      data => {
        this.pays = data; 

        this.pays = new Pays(this.pays.code);

        this.ville = new Villes(this.id,this.pays,this.ville.codePostal,this.ville.nom)

        this.villeService.updateVille(this.ville).subscribe(
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
