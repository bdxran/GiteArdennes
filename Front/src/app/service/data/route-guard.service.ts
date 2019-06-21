import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { BasicAuthentificateService } from '../basic-authentificate.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate{

  constructor(private route: Router,
      private basicAuthentificate: BasicAuthentificateService
    ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean|UrlTree>|Promise<boolean|UrlTree>|boolean|UrlTree {
    if(this.basicAuthentificate.isUserLoggedIn() == true) {
      return true;
    } else {
      this.route.navigate(["/signin"]);

      return false;
    }
  }
}
