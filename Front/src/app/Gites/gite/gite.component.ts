import { Component, OnInit } from '@angular/core';
import { GiteService, Gites } from '../../service/gite.service';
import { PhotoService } from '../../service/photo.service';
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

        // this.photoService.executeDataPhotoService().subscribe(
        //   photoReponse => {
        //     this.photo = photoReponse;
        //   }
        // );
      }
    );
  }

  // public getPhotoByIdGite(id) {
  //   for(let ph of this.photo) {
  //     if(ph.idGite == id) {
  //       this.src = ph.lien;
  //     }
  //   }
  // }

  public delete(id) {
    this.giteService.deleteGite(id).subscribe();
    this.navigate("gite");
  }

  public navigate(direction,id?){
    if(id!=null) {
      this.route.navigate([direction,id]);
    } else {
      this.route.navigate([direction]);
    }
  }
}
