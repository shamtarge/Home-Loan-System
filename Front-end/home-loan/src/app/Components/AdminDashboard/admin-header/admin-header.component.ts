import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent {
  username:any;
  constructor(private route:Router){};
  ngonInit(){
    this.username = localStorage.getItem('user');
  }
  logOut(){
    localStorage.clear();
    this.route.navigate(['\home']);
  }
}
