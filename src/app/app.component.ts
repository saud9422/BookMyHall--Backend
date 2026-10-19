import { Component } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { filter, pipe } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FE';
  showNavbar = true;
  constructor(private router:Router){
    this.router.events
    .pipe(
      filter(event=>event instanceof NavigationEnd)
    )
    .subscribe(()=>{
      const route = this.router.routerState.root;
      this.showNavbar =route.firstChild?.snapshot.data['showNavbar'] ?? true;
    });
  }

    
}
