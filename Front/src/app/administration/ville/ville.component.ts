import { Component, OnInit } from '@angular/core';
import { VilleService } from 'src/app/service/data/ville.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ville',
  templateUrl: './ville.component.html',
  styleUrls: ['./ville.component.css']
})
export class VilleComponent implements OnInit {

  private ville;

  constructor(
    private villeService: VilleService,
    private route: Router,
  ) { }

  ngOnInit() {
    this.villeService.getVilles().subscribe(
      data => {
        this.ville = data;
      }
    );
  }

  public navigate(direction,id) {
    if(id != null) {
      this.route.navigate([direction,id]);
    } else {
      this.route.navigate([direction]);
    }
  }

}
