import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-client-profile',
  templateUrl: './client-profile.component.html',
  styleUrls: ['./client-profile.component.css']
})
export class ClientProfileComponent {
  constructor(private client: HttpClient){};
  obj:any;
  ngOnInit(){
    var username = localStorage.getItem('user');
    this.client.get('http://localhost:8083/client/'+username).subscribe((data)=>{
      this.obj = data;
    });
  }
}
