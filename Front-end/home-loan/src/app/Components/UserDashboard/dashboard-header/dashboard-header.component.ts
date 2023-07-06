import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard-header',
  templateUrl: './dashboard-header.component.html',
  styleUrls: ['./dashboard-header.component.css']
})
export class DashboardHeaderComponent {
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
