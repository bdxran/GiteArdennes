import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PaysService } from 'src/app/service/data/pays.service';

@Component({
  selector: 'app-pays',
  templateUrl: './pays.component.html',
  styleUrls: ['./pays.component.css']
})
export class PaysComponent implements OnInit {

  private pays;

  constructor(
    private paysService: PaysService,
    private route: Router,
  ) { }

  ngOnInit() {
    this.paysService.getPays().subscribe(
      data => {
        this.pays = data;
      }
    );
  }

  public navigate(direction,id){
    if(id != null){
      this.route.navigate([direction,id]);
    } else {
      this.route.navigate([direction]);
    }
  }

}
