import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegisterUser } from '../models/register_user';
import { LoginUser } from '../models/login_user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http : HttpClient) { }
  private registerUrl ="http://localhost:8080/api/auth/register";
  private loginUrl ="http://localhost:8080/api/auth/login";
  private profileUrl ="http://localhost:8080/api/auth/profile"

  registerUser(user:RegisterUser){
    return this.http.post(this.registerUrl,user, {responseType:'text'});
  }

  loginUser(loginuser:LoginUser){
    return this.http.post(this.loginUrl,loginuser,{responseType:'text',withCredentials:true})

  }
  getUser(): Observable<RegisterUser>{
    return this.http.get<RegisterUser>(this.profileUrl,{withCredentials: true});

  }
}
