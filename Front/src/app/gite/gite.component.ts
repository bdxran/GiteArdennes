import { Component, OnInit } from '@angular/core';
import { GiteService } from '../service/gite.service';
import { PhotoService } from '../service/photo.service';

@Component({
  selector: 'app-gite',
  templateUrl: './gite.component.html',
  styleUrls: ['./gite.component.css']
})
export class GiteComponent implements OnInit {

  gite;
  photo;
  src;

  constructor(private giteService: GiteService,
    private photoService: PhotoService) { }

  ngOnInit() {
    this.giteService.executeDataGiteService().subscribe(
      giteReponse => {
        this.gite = giteReponse;

        this.photoService.executeDataPhotoService().subscribe(
          photoReponse => {
            this.photo = photoReponse;
          },
          error => {
            console.log(error);
          }
        );
      },
      error => {
        console.log(error);
      }
    );
  }

  photoSrc(id:number) {
    for(let photos of this.photo) {
      if(Object.getOwnPropertyDescriptor(photos, 'idgite').value == id) {
        this.src = Object.getOwnPropertyDescriptor(photos, 'lien').value;
      }
    }
    return this.src;
  }

}
