import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SpringApiserviceService } from 'src/app/api-service.service';

@Component({
  selector: 'app-apply-loan-admin',
  templateUrl: './apply-loan-admin.component.html',
  styleUrls: ['./apply-loan-admin.component.css']
})
export class ApplyLoanAdminComponent {
  loginForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private client: HttpClient, private route:Router, private service:SpringApiserviceService){
    this.loginForm =  this.formBuilder.group({
      loan: new FormControl('', Validators.compose([Validators.required])),
      term: new FormControl('', Validators.compose([Validators.required])),
      interest: new FormControl('', Validators.compose([Validators.required])),
      address: new FormControl('', Validators.compose([Validators.required])),
      salary: new FormControl('', Validators.compose([Validators.required])),
      clientId: new FormControl('', Validators.compose([Validators.required]))
    });
  }
  // clientId:Number = 0;
  body:any;
  uri = 'http://localhost:8083/addAccount';
  address:string = '';
  loan:Number = 0;
  period:Number = 0;
  interest:Number = 0;
  salary:Number = 0;
  clientId:Number = 0;

  displayEligiblePrompt:boolean = false;
  displayUneligiblePrompt:boolean = false;
  successPage:boolean = false;
  failurePage:boolean = false;
  result:boolean = false;
  EMI:any;
  newEMI:any;
  newLoan:Number=0;
  newInterest:Number=0;

  onSubmit(){
    this.address =  this.loginForm.get('address')?.value,
    this.loan = this.loginForm.get('loan')?.value,
    this.period = this.loginForm.get('term')?.value,
    this.interest = this.loginForm.get('interest')?.value,
    this.salary = this.loginForm.get('salary')?.value,
    this.clientId = this.loginForm.get('clientId')?.value

    this.checkEligibilty();

    console.log("After Body")
  }

  checkEligibilty() {
    this.EMI = this.calculateEmi(this.interest,this.period,this.loan);
    if(parseInt(this.loan.toString()) > 50 * parseInt(this.salary.toString())){
      this.newLoan = 50 * parseInt(this.salary.toString());
      this.newInterest = this.interest;
      this.newEMI = this.calculateEmi(this.interest,this.period,this.newLoan);
      this.displayUneligiblePrompt = true;
      console.log("Client is NOT Eligible");
    }
    else{
      console.log("Client is Eligible");
      this.displayEligiblePrompt = true;
    }
    // var principle = 0;
    // var balanceOutstanding = parseInt(this.loan.toString()) - principle;
    // var monthlyInterest = balanceOutstanding - rate;
    // principle = EMI - monthlyInterest;
  }

  calculateEmi(interest:Number, period:Number, loan:Number){
    let rate = parseInt(interest.toString())/1200;
    let calcu1 = Math.pow(1+rate,parseInt(period.toString()));
    let calcu2 = Math.pow(1+rate,parseInt(period.toString()))-1;
    let EMI = Math.round((parseInt(loan.toString()) * rate * calcu1)/calcu2); 
    return EMI;
  }

  accept_unEligible(){
    this.body = {
      "home_address": this.address,
      "loan_ammount": this.loan,
      "period" : this.period,
      "interest" : this.interest,
      "salary" : this.salary,
      "amount_to_pay": this.newLoan,
      "premium_amount": this.newEMI,
      "status": "Pending",
      "client_id":{
          "client_id": this.clientId
      }
    }
    console.log("Body is : ",this.body);
    this.postLoanRequest();
  }

  accept_eligible(){
    console.log("Inside Accepted!!!!");
    this.body = {
      "home_address": this.address,
      "loan_ammount": this.loan,
      "period" : this.period,
      "interest" : this.interest,
      "salary" : this.salary,
      "amount_to_pay": this.loan,
      "premium_amount": this.EMI,
      "status": "Pending",
      "client_id":{
          "client_id": this.clientId
      }
    }
    console.log("Body is : ",this.body);
    this.postLoanRequest();
  }

  postLoanRequest(){
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.client.post<any>( this.uri, this.body, { headers}).subscribe((res)=> {
      console.log("Result of loanRequest :", res);
      if(res){
        this.displayEligiblePrompt = false;
        this.successPage = true;
      }
      else {
        this.displayEligiblePrompt = false;
        this.failurePage = true
      }
    });
  }

  home(){
    this.route.navigate(['/client']);
  }
  status(){
    this.route.navigate(['/user/status']);
  }
  applyLoan(){
    this.displayEligiblePrompt = false;
    this.displayUneligiblePrompt = false;
    this.failurePage = false;
    this.successPage = false;
    this.route.navigate(['/applyLoan']);
  }

  rejected(){
    console.log("Inside Rejected!!!");
    this.route.navigate(['/client']);
  }
}
