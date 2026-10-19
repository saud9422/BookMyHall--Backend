import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Dashboard } from '../models/dashboard';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http:HttpClient) { }
  url = "http://localhost:8080/dashboard/get"

  getDashboard(): Observable <Dashboard>{
    return this.http.get<Dashboard>(this.url,{withCredentials:true})
  }
}


