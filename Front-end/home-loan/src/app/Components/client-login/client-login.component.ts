import { SpringApiserviceService } from 'src/app/api-service.service';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-client-login',
  templateUrl: './client-login.component.html',
  styleUrls: ['./client-login.component.css']
})
export class ClientLoginComponent {
  loginForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private client: HttpClient, private service: SpringApiserviceService,private route:Router){
    this.loginForm =  this.formBuilder.group({
      userName: new FormControl('', Validators.compose([Validators.required])),
      password: new FormControl('', Validators.compose([Validators.required]))
    });
  }
  user_name : string = '';
  password : String = '';
  showError: boolean = false;
  // data : boolean = true;
  onSubmit():void{
    this.user_name  = this.loginForm.get('userName')?.value;
    this.password  = this.loginForm.get('password')?.value;
    console.log(this.user_name);
    console.log(this.password);
    this.showError = this.service.validateLogin('http://localhost:8083/searchUserName/', this.user_name, 'http://localhost:8083/searchPassword/', this.password, '/client')
  }
}
