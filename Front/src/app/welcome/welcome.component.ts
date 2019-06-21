import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PhotoService } from '../service/data/photo.service';
import { GiteService } from '../service/data/gite.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  private gite;

  constructor(private giteService: GiteService,
    private photoService: PhotoService,
    private route: Router) { }

  ngOnInit() {
    this.giteService.getGites().subscribe(
      giteReponse => {
        this.gite = giteReponse;
      }
    );
  }

  public navigate(direction,id?){
    if(id!=null) {
      this.route.navigate([direction,id]);
    } else {
      this.route.navigate([direction]);
    }
  }

}
