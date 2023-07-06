import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from'@angular/common/http'
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SpringApiserviceService {
  // loanResponse:boolean;
  constructor(private client: HttpClient, private route:Router) {}

  getRequests(url:string){
    return this.client.get(url);
  }
  loanResult: boolean = false;
  postRequest(url:any,obj:any, success: String, failure: String, username: String){
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    const body = obj;
    localStorage.setItem('user', username.toString());
    this.client.post<any>( url, body, { headers}).subscribe( {
      // console.log(data);
      next: (response) => {
        console.log(response);
        if(success) this.route.navigate([success]);
        // this.route.navigate(['/client']);
      },
      error: (error) => {
        console.log(error);
        if(success) this.route.navigate([failure]);
      }
    });
  }  
  
  // async LoanRequest(url:any,obj:any){
  //   const headers = new HttpHeaders().set('Content-Type', 'application/json');
  //   const body = obj;
  //   var result = this.client.post<any>( url, body, { headers}).subscribe((res)=> {
  //     console.log("Result of loanRequest :", res);

  //     if(res) this.loanResponse = true;
  //     else {this.loanResponse = false;}
  //     return res;
  //   });
  //   return result;
  // }  

  // getClientId(userName:String):Number{
  //   this.client.get('http://localhost:8083/client/'+userName).subscribe((result) =>{
  //     console.log(result.);
  //   });
  //   return 0;
  // }


  validateLogin(usernameUrl:any, username:String, passwordUrl:any, password:String, success: String) : boolean{
    var result = true;
    this.client.get(usernameUrl+username).subscribe(nameCorrect => {
      if(nameCorrect){
        console.log("Is name correct: ", nameCorrect);
        this.client.post(passwordUrl+password, username).subscribe(pswdCorrect=>{
          localStorage.setItem('user', username.toString());
          if(pswdCorrect){
            console.log("Is password correct: ", pswdCorrect);
            this.route.navigate([success]);
            result = false;
            return false;
          }
          else{
            result = true;
            return true;
          }
        })
      }
      result = true;
      return true;
    });
    return result;
  }

}
