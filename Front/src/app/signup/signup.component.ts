import { Component, OnInit } from '@angular/core';
import { BasicInscriptionService } from '../service/basic-inscription.service';
import { Router } from '@angular/router';
import { BasicAuthentificateService } from '../service/basic-authentificate.service';
import { Admins } from '../service/admin.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  private admin;
  private username: string;
  private password: string;
  private confirmPassword: string;
  private invalidPassword: boolean = false;

  constructor(private basicInscript: BasicInscriptionService,
    private basicAuth: BasicAuthentificateService,
    private router: Router) { }

  ngOnInit() {
  }

  public basicInscrip() {
    if(this.password == this.confirmPassword) {
      this.invalidPassword = false;
      this.admin = new Admins(0,this.username,this.password);
      this.basicInscript.exeInscripServ(this.admin).subscribe(
        data => { 
          console.log(data);
        },
        error => {
          console.log(error);
        }
      );
    } else {
      return this.invalidPassword = true;
    }
  }

}
