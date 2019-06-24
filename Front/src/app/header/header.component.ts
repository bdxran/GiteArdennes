import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BasicAuthentificateService } from '../service/basic-authentificate.service';
import { GiteService } from '../service/data/gite.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private username: string = "";
  private role: string = "";
  private gites;

  constructor(private route: ActivatedRoute,
    private basicAuth: BasicAuthentificateService,
    private giteService: GiteService,
    private router: Router
    ) { }

  ngOnInit() {
    
    this.giteService.getGites().subscribe(
      data => {
        this.gites = data;
        this.username = this.basicAuth.getAuthenticatedUser();
        this.role = this.basicAuth.getAuthenticatedRole();
      }
    );
  }

  public navigate(direction,id?){
    if(id!=null) {
      this.router.navigate([direction,id]);
    } else {
      this.router.navigate([direction]);
    }
  }
}
