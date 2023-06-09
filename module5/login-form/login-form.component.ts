import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  loginForm : FormGroup
  constructor() {
    this.loginForm = new FormGroup({
      email : new FormControl('',[Validators.email]),
      password : new FormControl('',[Validators.minLength(6)])
    })

  }

  ngOnInit(): void {
  }

  login() {
    console.log(this.loginForm)
  }
}
