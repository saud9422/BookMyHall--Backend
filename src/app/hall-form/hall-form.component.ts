import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { save_hall } from '../models/save_hall';
import { HallService } from '../service/hall.service';

@Component({
  selector: 'app-hall-form',
  templateUrl: './hall-form.component.html',
  styleUrls: ['./hall-form.component.css'],
})
export class HallFormComponent {
  constructor(private route: Router, private hall_service : HallService) { }

  selectedImage: File[] = [];
  hall : save_hall[]=[];
  selectImage(event: Event) {

    const input = event.target as HTMLInputElement;

    if (input.files) {
      this.selectedImage = Array.from(input.files);
    }
  }

  Savehall(){
    const formdata = new FormData();
    formdata.append(
      'hall',
      new Blob([JSON.stringify(this.hall)],{
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
