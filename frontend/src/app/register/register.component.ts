import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user:any = {}
  userToSave:any = {};

  constructor() { 
  }

  ngOnInit(): void { 
  }

  

  onSubmit(form) {
    console.log(form.value);
    this.userToSave = form.value;
    console.log(this.userToSave);
    
    
  }

}
