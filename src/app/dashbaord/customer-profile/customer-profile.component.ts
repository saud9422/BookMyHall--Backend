import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Dashboard } from 'src/app/models/dashboard';
import { save_hall } from 'src/app/models/save_hall';
import { DashboardService } from 'src/app/service/dashboard.service';
import { HallService } from 'src/app/service/hall.service';


@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit{
  constructor(private dashboard_service:DashboardService , private hall_service: HallService){}
    activeSection: string = 'profile';

  ngOnInit(): void {
      this.getDashboard();
  }

  hall = {
    hallName: '',
    description: '',
    hallType: '',
    bookingMode: '',
    address: '',
    capacity: null,
    price: null
  };

  changeSection(section: string): void {
    this.activeSection = section;
  }

  submitHall(): void {
    console.log('Hall listing:', this.hall);

    // Later you can replace this with your Spring Boot API call.
    alert('Hall listing submitted successfully!');
  }

  updateProfile(): void {
   

    // Call your backend API here.
    alert('Profile updated successfully!');
  }

  updatePassword(): void {
    alert('Password updated successfully!');
  }

  logout(): void {
    // Add your Spring Security logout implementation here.
    console.log('Logout clicked');
  }

  dashboard_data! : Dashboard;
  savehall_data! :save_hall;
  selectedImage: File[] = [];

  getDashboard(){
    this.dashboard_service.getDashboard().subscribe({
      next : (Response:Dashboard)=>{

        this.dashboard_data = Response;
        console.log(this.dashboard_data);

      },
      error :(err)=>{
        console.error("Data not found for the current user....",err);
      }
    })
  }

  onImagesSelected(event : Event){
    const input = event.target as HTMLInputElement;

  if(input.files){
    this.selectedImage = Array.from(input.files)
  }
  }
  
  Savehall(){
    const formdata = new FormData();
    formdata.append(
      'hall',
      new Blob([JSON.stringify(this.savehall_data)],{
        type: 'application/json'
      }));

      this.selectedImage.forEach((image)=>{
        formdata.append('images',image)
      });

      this.hall_service.saveHall(formdata).subscribe({
        next :(response)=>{
          console.log(response)
        },
        error: (error)=>{
          console.error(error)
        }
      })

  }


  }

