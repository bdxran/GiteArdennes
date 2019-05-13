import { Component, OnInit } from '@angular/core';
import { GiteService, Gites } from '../service/gite.service';

@Component({
  selector: 'app-gite',
  templateUrl: './gite.component.html',
  styleUrls: ['./gite.component.css']
})
export class GiteComponent implements OnInit {

  gite:Gites[];

  constructor(private giteService: GiteService) { }

  ngOnInit() {
    this.giteService.executeDataGiteService().subscribe(
      giteReponse => this.handleSuccessFulGiteResponse(giteReponse)
    );
  }

  handleSuccessFulGiteResponse(giteReponse){
    this.gite = giteReponse._embedded.gitesResources;
  }

}
