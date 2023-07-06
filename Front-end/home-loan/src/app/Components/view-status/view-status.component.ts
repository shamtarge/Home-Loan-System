import { SpringApiserviceService } from 'src/app/api-service.service';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-status',
  templateUrl: './view-status.component.html',
  styleUrls: ['./view-status.component.css']
})
export class ViewStatusComponent {
  user = {
    "firstName": "",
    "lastName": "",
    "client_id": 0,
    "period": 0,
    "premium_amount": 0,
    "amount_to_pay": 0,
    "status": "",
  }
  obj:any;
  constructor( private service:SpringApiserviceService, private client: HttpClient){};

  ngOnInit(){
    var username = localStorage.getItem('user');
    this.client.get('http://localhost:8083/account/'+username).subscribe((data)=>{
      this.obj = data;
      console.log(this.obj.client_id.lastName);
      this.user.firstName = this.obj.client_id.firstName;
      this.user.lastName =  this.obj.client_id.lastName;
      this.user.client_id = this.obj.client_id.client_id;
      this.user.amount_to_pay = this.obj.amount_to_pay;
      this.user.premium_amount = this.obj.premium_amount;
      this.user.period = this.obj.period;
      this.user.status = this.obj.status;
    });
  }

}
