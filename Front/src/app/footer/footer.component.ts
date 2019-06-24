import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BasicAuthentificateService } from '../service/basic-authentificate.service';
import { GiteService } from '../service/data/gite.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  private username: string = "";
  private role: string = "";
  private gites;

  constructor(private route: ActivatedRoute,
    private basicAuth: BasicAuthentificateService,
    private giteService: GiteService
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

}
