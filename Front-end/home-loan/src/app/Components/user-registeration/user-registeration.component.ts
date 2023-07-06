import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http'
import { SpringApiserviceService } from 'src/app/api-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-registeration',
  templateUrl: './user-registeration.component.html',
  styleUrls: ['./user-registeration.component.css']
})
export class UserRegisterationComponent implements OnInit {
  Post_Url = "http://localhost:8083/addClient";
  loginForm: FormGroup;
  error_messages = {
    'firstName': [
      { type: 'required', message: 'First Name is required.' },
    ],

    'lastName': [
      { type: 'required', message: 'Last Name is required.' }
    ],

    'mobileNumber': [
      { type: 'required', message: 'Mobile Number is required.' }
    ],

    'email': [
      { type: 'required', message: 'Email is required.' },
      { type: 'minlength', message: 'Email length.' },
      { type: 'maxlength', message: 'Email length.' },
      { type: 'required', message: 'please enter a valid email address.' }
    ],

    'password': [
      { type: 'required', message: 'password is required.' },
      { type: 'minlength', message: 'password length.' },
      { type: 'maxlength', message: 'password length.' }
    ],
    'confirmPassword': [
      { type: 'required', message: 'password is required.' },
      { type: 'minlength', message: 'password length.' },
      { type: 'maxlength', message: 'password length.' }
    ],
    'gender': [
      { type: 'required', message: 'Gender is required.' }
    ],
    'userName': [
      { type: 'required', message: 'User Name is required.' }
    ],
    'state': [
      { type: 'required', message: 'state is required.' }
    ],
    'city': [
      { type: 'required', message: 'city is required.' }
    ],
    'pincode': [
      { type: 'required', message: 'pincode is required.' }
    ],
    'dateOfBirth': [
      { type: 'required', message: 'Date of Birth is required.' }
    ],
    'checkbox': [
      { type: 'required', message: 'Tick the checkbox' }
    ],
  }
  ngOnInit(): void {}
  // value:any;
  password(formGroup: FormGroup) {
    const pass = formGroup.get('password')?.value;
    const cnfpass = formGroup.get('confirmpassword')?.value;
    return pass === cnfpass ? null : { passwordNotMatch: true };
  }
  body: any;
  constructor( private formBuilder: FormBuilder, private service:SpringApiserviceService, private route:Router){
    this.loginForm = this.formBuilder.group({
      firstName: formBuilder.control('',Validators.compose([Validators.required])),
      lastName: formBuilder.control('', Validators.compose([Validators.required])),
      mobileNumber: formBuilder.control('', Validators.compose([Validators.required,
        Validators.pattern('^[0-9]{10}$')
      ])),
      email: formBuilder.control('', Validators.compose([
        Validators.required,
        Validators.minLength(6),
        Validators.maxLength(30)
      ])),
      gender: formBuilder.control('', Validators.compose([
        Validators.required,
      ])),
      userName: formBuilder.control('', Validators.compose([
        Validators.required,
      ])),
      password: formBuilder.control('', Validators.compose([
        Validators.required,
        Validators.minLength(8),
        Validators.maxLength(30)
      ])),
      confirmPassword: formBuilder.control('', Validators.compose([
        Validators.required,
        Validators.minLength(8),
        Validators.maxLength(30)
      ])),
      state: formBuilder.control('', Validators.compose([
        Validators.required,
      ])),
      city: formBuilder.control('', Validators.compose([
        Validators.required,
      ])),
      pincode: formBuilder.control('', Validators.compose([
        Validators.required,
      ])),
      dateOfBirth: formBuilder.control('', Validators.compose([
        Validators.required,
        // Validators.pattern(/^\d{1,2}\.\d{1,2}\.\d{4}$/)
      ])),
      checkbox: formBuilder.control('', Validators.compose([
        Validators.required,
      ]))
    },
    { 
      validators: this.password.bind(this)
    });
  }

  onSubmit(): void{
    this.body = {
        "firstName" : this.loginForm.get('firstName')?.value,
        "lastName" : this.loginForm.get('lastName')?.value,
        "mobileNumber" : this.loginForm.get('mobileNumber')?.value,
        "email" : this.loginForm.get('email')?.value,
        "date_of_birth" : this.loginForm.get('dateOfBirth')?.value,
        "gender" : this.loginForm.get('gender')?.value,
        "userName" : this.loginForm.get('userName')?.value,
        "password": this.loginForm.get('password')?.value,
        "state" : this.loginForm.get('state')?.value,
        "city" : this.loginForm.get('city')?.value,
        "pincode" : this.loginForm.get('pincode')?.value
    }
    this.service.postRequest('http://localhost:8083/addClient',this.body,'/client','/error', this.loginForm.get('userName')?.value);
    
  }

}
