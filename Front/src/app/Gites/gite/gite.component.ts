import { Component, OnInit } from '@angular/core';
import { GiteService, Gites } from '../../service/data/gite.service';
import { PhotoService } from '../../service/data/photo.service';
import { routerNgProbeToken } from '@angular/router/src/router_module';
import { Router } from '@angular/router';

@Component({
  selector: 'app-gite',
  templateUrl: './gite.component.html',
  styleUrls: ['./gite.component.css']
})
export class GiteComponent implements OnInit {

  private gite;
  private photo;
  private src;

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

  public delete(id) {
    this.giteService.deleteGite(id).subscribe();
    window.location.reload();
  }

  public navigate(direction,id?){
    if(id!=null) {
      this.route.navigate([direction,id]);
    } else {
      this.route.navigate([direction]);
    }
  }
}
