import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-change-admin-password',
  templateUrl: './change-admin-password.component.html',
  styleUrls: ['./change-admin-password.component.css']
})
export class ChangeAdminPasswordComponent {
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
    this.client.put('http://localhost:8082/updatePassword/'+username,this.loginForm.get('password')?.value, {headers}).subscribe(data=>{
      console.log("Data is : ", data);
    });
    this.showSuccess = true;
    window.location.reload();
  }
  
}
