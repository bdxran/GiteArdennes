import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username: string;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.username = this.route.snapshot.params['username'];
    console.log(this.username)
  }
}
