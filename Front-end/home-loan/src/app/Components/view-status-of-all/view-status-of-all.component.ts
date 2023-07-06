import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SpringApiserviceService } from 'src/app/api-service.service';

@Component({
  selector: 'app-view-status-of-all',
  templateUrl: './view-status-of-all.component.html',
  styleUrls: ['./view-status-of-all.component.css']
})
export class ViewStatusOfAllComponent {
  obj:any;
  constructor( private service:SpringApiserviceService, private client: HttpClient, private route:Router){};

  ngOnInit(){
    // var username = localStorage.getItem('user');
    this.client.get('http://localhost:8083/accounts').subscribe((data)=>{
      console.log("All CLients data : ",data);
      this.obj = data;
      console.log("All CLients Object: ",data);
    });
  }
  approve(accountID : any){
    console.log("Approve Event: ",accountID);
    this.updateStatus(accountID,"Approved");
  }
  reject(accountID : any){
    console.log("Reject Event: ",accountID);
    this.updateStatus(accountID,"Rejected");
  }
  updateStatus(accountID:any, status:String){
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.client.put('http://localhost:8083/updateStatus/'+accountID,status,{ headers}).subscribe((data)=>{
      console.log("Punt Request data: ", data);
      
    });
    window.location.reload();
    // this.route.navigate(['/status']);
  }
}
