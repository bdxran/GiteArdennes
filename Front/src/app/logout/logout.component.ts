import { Component, OnInit } from '@angular/core';
import { BasicAuthentificateService } from '../service/basic-authentificate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private basicAuth: BasicAuthentificateService,
    private route: Router) { }

  ngOnInit() {
    this.basicAuth.logout();
    this.route.navigate(["welcome"]);
  }

}
