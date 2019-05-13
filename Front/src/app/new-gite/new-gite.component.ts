import { Component, OnInit } from '@angular/core';
import { GiteService, Gites } from '../service/gite.service';

@Component({
  selector: 'app-new-gite',
  templateUrl: './new-gite.component.html',
  styleUrls: ['./new-gite.component.css']
})
export class NewGiteComponent implements OnInit {

  private gite;
  private nom: string;
  private adresse1: string;
  private adresse2: string;
  private description: string;

  constructor(private giteService: GiteService) { }

  ngOnInit() {
  }

  public addGite() {
    this.gite = new Gites(50,1,this.nom,this.adresse1,this.adresse2,this.description);
    this.giteService.newGite(this.gite).subscribe(
      data => { 
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  
  }

}
