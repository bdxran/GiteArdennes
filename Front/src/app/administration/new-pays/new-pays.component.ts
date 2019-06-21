import { Component, OnInit } from '@angular/core';
import { PaysService, Pays } from 'src/app/service/data/pays.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-pays',
  templateUrl: './new-pays.component.html',
  styleUrls: ['./new-pays.component.css']
})
export class NewPaysComponent implements OnInit {

  private pays;
  private nom;

  constructor(
    private paysService: PaysService,
    private route: Router,
  ) { }

  ngOnInit() {
  }

  public newPays() {
    this.pays = new Pays("",this.nom);

    this.paysService.newPays(this.pays).subscribe(
      data => {
        console.log(data);

        this.navigate("pays");
      }
    );
  }

  public navigate(direction) {
    this.route.navigate([direction]);
  }

}
