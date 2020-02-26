import { Injectable } from '@angular/core';
import { User } from 'src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  /*https://www.techiediaries.com/angular/angular-9-reactive-forms-validation-tutorial-example/*/

  public login(userInfo: User){
    localStorage.setItem('ACCESS_TOKEN', "access_token");
  }

  public isLoggedIn(){
    return localStorage.getItem('ACCESS_TOKEN') !== null;

  }

  public logout(){
    localStorage.removeItem('ACCESS_TOKEN');
  }
}