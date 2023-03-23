import { Component, OnInit } from '@angular/core';
import {User} from "./model/User";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  user : User = {}

  reactiveForm : FormGroup;
  constructor() {
    this.reactiveForm = new FormGroup(
      {
        userName : new FormControl('',[Validators.email]),
        password : new FormControl('',[Validators.minLength(6)]),
        confirmPassword : new FormControl('',[Validators.minLength(6)]),
        country : new FormControl('',[Validators.required]),
        age : new FormControl('',[Validators.min(18)]),
        gender : new FormControl('',[Validators.required]),
        phone : new FormControl('',[Validators.pattern('/^\\+84\\d{9,10}$/')])
      }
    )
  }
  ngOnInit(): void {
  }

  createNewUser() {
    console.log(this.reactiveForm)
  }
}
