import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BasicAuthentificateService } from '../service/basic-authentificate.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username: string;

  constructor(private route: ActivatedRoute,
    private basicAuth: BasicAuthentificateService) { }

  ngOnInit() {
    this.username = this.basicAuth.getAuthenticatedUser();
    console.log(this.username)
  }

  public getUsername() {
    this.username = this.basicAuth.getAuthenticatedUser();
    console.log(this.username)
  }
}
