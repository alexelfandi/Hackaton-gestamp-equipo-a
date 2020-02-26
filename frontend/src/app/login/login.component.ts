import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/authentication/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:any = {};
  usersArray:any = [];
  loginStatus:string = '';
  test1 = {email:"joncas@gmail.com", password:"Contraseña1"};
  test2 = {email:"alex@gmail.com", password:"password1"};
  test3 = {email:"alvaro@gmail.com", password:"password2"};

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.usersArray.push(this.test1, this.test2, this.test3)
  }

  onSubmit(form) {
    console.log(form.value);
    this.user = form.value;
    console.log(this.user);

    var searchUser = this.usersArray.find(element=> element.email===form.value.email);
    
    if(searchUser!=undefined){
      console.log("Email encontrado: " + JSON.stringify(searchUser));
      if(searchUser.password===form.value.password){
        console.log("Contraseña Acertada");
        this.loginStatus = "success";
        this.authService.login(form.value);
        console.log(this.authService.isLoggedIn());
        console.log(localStorage.getItem('access_token'));
        
        
      }else{
        console.log("Contraseña incorrecta");
        this.loginStatus = "fail";
      }
    }else{
      console.log("Usuario no encontrado");
      this.loginStatus = "fail";
    }
  }
}
