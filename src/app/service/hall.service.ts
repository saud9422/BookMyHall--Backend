import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { save_hall } from '../models/save_hall';

@Injectable({
  providedIn: 'root'
})
export class HallService {

  constructor(private http:HttpClient) {}
   
  private getHallUrl ="http://localhost:8080/hall/all"
  private saveHallUrl ="http://localhost:8080/hall/save"

  getAllHalls() : Observable<save_hall[]> {
    return this.http.get<save_hall[]>(this.getHallUrl,{withCredentials : true})
  }

  saveHall(formdata : FormData){
    return this.http.post(this.saveHallUrl, formdata, {withCredentials : true})
  }

}
