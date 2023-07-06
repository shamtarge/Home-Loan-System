import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent {
  constructor(private client: HttpClient){};
  obj:any;
  ngOnInit(){
    var username = localStorage.getItem('user');
    console.log("UserName is :", username);
    this.client.get('http://localhost:8082/adminUserName/'+username).subscribe((data)=>{
      this.obj = data;
    });
  }
}
