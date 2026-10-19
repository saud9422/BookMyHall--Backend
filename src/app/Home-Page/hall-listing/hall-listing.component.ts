import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { save_hall } from 'src/app/models/save_hall';
import { HallService } from 'src/app/service/hall.service';

@Component({
  selector: 'app-hall-listing',
  templateUrl: './hall-listing.component.html',
  styleUrls: ['./hall-listing.component.css']
})
export class HallListingComponent implements OnInit {
 halls: save_hall[] = [];

constructor(
  private route: Router,
  private hallService: HallService
) {}

ngOnInit(): void {
  this.getAllHalls();
}

getAllHalls():void{
    this.hallService.getAllHalls().subscribe({
    next: (response) => {
      this.halls = response;
      console.log(response)
    },
    error: (err) => {
      console.error("Something is not working...", err);
    }
  });
}

viewHall(id:number){
  this.route.navigate(['/'])
}

}
