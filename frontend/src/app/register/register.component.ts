import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user:any = {}
  userForm:any;
  angForm: FormGroup;
  constructor(private fb: FormBuilder) { 
    this.createForm();
  }

  ngOnInit(): void {  
  }

  createForm() {
    this.angForm = this.fb.group({
       name: ['', Validators.required ]
    });
  }

}
