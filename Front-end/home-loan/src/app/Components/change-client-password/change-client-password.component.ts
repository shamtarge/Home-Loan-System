import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SpringApiserviceService } from 'src/app/api-service.service';

@Component({
  selector: 'app-change-client-password',
  templateUrl: './change-client-password.component.html',
  styleUrls: ['./change-client-password.component.css']
})
export class ChangeClientPasswordComponent {
  showSuccess:boolean = false;
  loginForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private client: HttpClient, private route:Router){
    this.loginForm =  this.formBuilder.group({
      userName: new FormControl('', Validators.compose([Validators.required])),
      password: new FormControl('', Validators.compose([Validators.required]))
    });
  }
  changePassword(){
    var username = localStorage.getItem('user');
    console.log("username is : ", username)
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.client.put('http://localhost:8083/updatePassword/'+username,this.loginForm.get('password')?.value, {headers}).subscribe(data=>{
      console.log("Data is : ", data);
    });
    this.showSuccess = true;
    window.location.reload();
  }
  
}
