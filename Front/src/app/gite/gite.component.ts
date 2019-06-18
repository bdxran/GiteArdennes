import { Component, OnInit } from '@angular/core';
import { GiteService } from '../service/gite.service';

@Component({
  selector: 'app-gite',
  templateUrl: './gite.component.html',
  styleUrls: ['./gite.component.css']
})
export class GiteComponent implements OnInit {

  private gite;

  constructor(private giteService: GiteService) { }

  ngOnInit() {
    this.giteService.executeDataGiteService().subscribe(
      giteReponse => {
        console.log(giteReponse)
        this.gite = giteReponse;
      }
    );
  }
}
