import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SaisonService } from 'src/app/service/data/saison.service';

@Component({
  selector: 'app-saison',
  templateUrl: './saison.component.html',
  styleUrls: ['./saison.component.css']
})
export class SaisonComponent implements OnInit {

  private saison;

  constructor(
    private saisonService: SaisonService,
    private route: Router,
  ) { }

  ngOnInit() {
    this.saisonService.getSaisons().subscribe(
      data => {
        this.saison = data;
      }
    );
  }

  public delete(id) {
    this.saisonService.deleteSaisons(id).subscribe(
      data => {
        console.log(data);

        window.location.reload();
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
