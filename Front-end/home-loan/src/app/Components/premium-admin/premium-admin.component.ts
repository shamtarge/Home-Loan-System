import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SpringApiserviceService } from 'src/app/api-service.service';

@Component({
  selector: 'app-premium-admin',
  templateUrl: './premium-admin.component.html',
  styleUrls: ['./premium-admin.component.css']
})
export class PremiumAdminComponent {
  user:any;
  constructor(private service: SpringApiserviceService, private client: HttpClient){}
  ngOnInit(){
    var userName = localStorage.getItem('user');
    console.log("UserName is : ", userName);
    this.client.get('http://localhost:8083/account/'+userName).subscribe(data =>{
      this.user = data;
      console.log("User is : ",data);
    });
    
  }
  
  account:any;
  payPremium(): void {
    var userName = localStorage.getItem('user');
    this.client.get('http://localhost:8083/account/'+userName).subscribe(data =>{
      this.account = data;
      console.log("User is : ",data);
      console.log("Inside Premium");
      let rate = parseInt(this.account.interest.toString())/1200;
      console.log("Rate is : ", rate);
      var monthlyInterest = Math.round((parseInt(this.account.loan_ammount.toString())-parseInt(this.account.principle_ammount.toString())) * rate);
      console.log("MOnthly Interest : ", monthlyInterest);
      var principle = Math.round(parseInt(this.account.premium_amount.toString()) - monthlyInterest);
      console.log("Principle Amount : ", principle);
      var newAmountToPay = Math.round(parseInt(this.account.amount_to_pay.toString()) - principle);
      console.log("New Amount to pay: ", newAmountToPay);
      this.updatePrinciple(principle);
      this.updateAmountToPay(newAmountToPay);
      window.location.reload();
    });
    // console.log("Inside Premium");
    // let rate = await parseInt(this.account.interest.toString())/1200;
    // console.log("Rate is : ", rate);
    // var monthlyInterest = Math.round((parseInt(this.account.loan_ammount.toString())-parseInt(this.account.principle_ammount.toString())) * rate);
    // console.log("MOnthly Interest : ", monthlyInterest);
    // var principle = Math.round(parseInt(this.account.premium_amount.toString()) - monthlyInterest);
    // console.log("Principle Amount : ", principle);
    // var newAmountToPay = Math.round(parseInt(this.account.loan_ammount.toString()) - principle);
    // console.log("New Amount to pay: ", newAmountToPay);
    // this.updatePrinciple(principle);
    // this.updateAmountToPay(newAmountToPay);
    // window.location.reload();
  }
  updatePrinciple(principle : Number){
    console.log("INside Update Principle");
    this.client.put('http://localhost:8083/updatePrinciple/'+this.account.account_Id, principle).subscribe(data=>{
      console.log("Update Principle Data: ",data);
    });
  }
  updateAmountToPay(amount : Number){
    console.log("Inside Update Amount to Pay");
    this.client.put('http://localhost:8083/updateAmount/'+this.account.account_Id, amount).subscribe(data =>{
      console.log("Update Amount : ",data);
    });
  }
}
