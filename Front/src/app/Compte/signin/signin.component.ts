import { Component, OnInit } from '@angular/core';
import { BasicAuthentificateService } from '../../service/basic-authentificate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  private username: string = "username";
  private password: string = "";
  private invalidLogin: boolean = false;

  constructor(private authentificate: BasicAuthentificateService,
    private router: Router) { }

  ngOnInit() {
  }

  public basicAuthSignIn() {
    this.authentificate.exeAuthServ(this.username,this.password).subscribe(
      data => { 
        console.log(data);
        this.router.navigate(['welcome', this.username]);
        this.invalidLogin = false;
      }, 
      
      error => {
          console.log(error);
          this.invalidLogin = true;
      }
    )
  }
}
