import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { GiteService } from 'src/app/service/gite.service';

@Component({
  selector: 'app-view-gite',
  templateUrl: './view-gite.component.html',
  styleUrls: ['./view-gite.component.css']
})
export class ViewGiteComponent implements OnInit {

  private id;
  private gite;
  private nom: string;
  private adresse1: string;
  private adresse2: string;
  private description: string;

  constructor(private giteService: GiteService,
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

  public navigate(direction) {
    this.route.navigate([direction]);
  }

}
