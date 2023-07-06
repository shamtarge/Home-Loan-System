import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-content',
  templateUrl: './admin-content.component.html',
  styleUrls: ['./admin-content.component.css']
})
export class AdminContentComponent {
  adminUserName = JSON.stringify(localStorage.getItem('user'));
  // console.log("adminUserName");
}
