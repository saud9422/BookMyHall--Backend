import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { RegisterUser } from '../models/register_user';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
   user: RegisterUser = {
    name: '',
    email: '',
    address: '',
    phone: 0,
    password: '',
    gender: ''
  }
  constructor(private userService: UserServiceService, private route:Router){}

  register(){
    this.userService.registerUser(this.user).subscribe({
      next:(response)=>{
        console.log("Register Successfull",response);
        alert("User Register Successfully..")
        this.route.navigate(['/login'])
      },
     error: (err)=> {
          console.log("Register Failed",err);
          alert("Register Failed..")
      },
    })
  }


  
}
