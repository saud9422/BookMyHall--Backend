import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { LoginUser } from '../models/login_user';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
    user: LoginUser={
      email:'',
      password:'',
  }

  
  constructor(private route:Router, private userservice:UserServiceService){

  }
  loginError=false;
 errorMessege='';
  loginUser(){
    this.userservice.loginUser(this.user).subscribe({
      next :(response)=>{
          console.log("LoginSuccessfull..");
          this.route.navigate(['/home']);
      },error:(error)=>{
        console.log("The Login Failed..");
        this.loginError=true;
        this.errorMessege ="The Email or Passward is Invalid"
       
      }
    });
    
  }
    showPassword: boolean = false;

  togglePasswordVisibility(): void {
    this.showPassword = !this.showPassword;
  }


}
