import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SpringApiserviceService } from 'src/app/api-service.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {
  loginForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private client: HttpClient, private route:Router, private service:SpringApiserviceService){
    this.loginForm =  this.formBuilder.group({
      userName: new FormControl('', Validators.compose([Validators.required])),
      password: new FormControl('', Validators.compose([Validators.required]))
    });
  }
  user_name : string = '';
  password : String = '';
  showError: boolean = false;
  onSubmit():void{
    this.user_name  = this.loginForm.get('userName')?.value;
    this.password  = this.loginForm.get('password')?.value;
    console.log(this.user_name);
    console.log(this.password);
    this.showError = this.service.validateLogin('http://localhost:8082/searchUserName/',this.user_name, 'http://localhost:8082/searchAdminPassword/' ,this.password, '/admin');
  }
}
