import { Component, OnInit } from '@angular/core';
import { Pays, PaysService } from 'src/app/service/data/pays.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-pays',
  templateUrl: './update-pays.component.html',
  styleUrls: ['./update-pays.component.css']
})
export class UpdatePaysComponent implements OnInit {

  private id;
  private pays;

  constructor(
    private paysService: PaysService,
    private route: Router,
    private router: ActivatedRoute
  ) { }

  ngOnInit() {
    this.id = this.router.snapshot.paramMap.get("id");

    this.paysService.getPaysById(this.id).subscribe(
      data => {
        this.pays = data;
      }
    );
  }

  public updatePays() {
    this.pays = new Pays(this.id,this.pays.nom);

    this.paysService.updatePays(this.pays).subscribe(
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
