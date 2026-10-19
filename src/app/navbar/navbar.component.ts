import { HttpClient } from '@angular/common/http';
import { Component, AfterViewInit,ElementRef, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from '../service/user-service.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit,AfterViewInit {
  isLogin: boolean = false;
  constructor(
    private route: Router,
    private http: HttpClient,
    private userService: UserServiceService,
    private elementRef:ElementRef
  ) {}
  ngOnInit(): void {
    this.checkLogin()
  }

  checkLogin(): void {
    this.userService.getUser().subscribe({
      next: (value)=> {
        this.isLogin= true;
      },
      error: (err)=>{
        this.isLogin = false;
      }
    });
  }

  ngAfterViewInit(): void {
      const element = this.elementRef.nativeElement.querySelectorAll('.reveal');
      const observer = new IntersectionObserver((entries)=>{
        entries.forEach(entry=>{
          if(entry.isIntersecting){
            entry.target.classList.add('show');
            observer.unobserve(entry.target);

          }
        })
      },
    {
      threshold : 0.15
    });
     element.forEach((element: Element) => {
      observer.observe(element);
    });

      
  }
  profile(){
    this.route.navigate(['dashboard/consumer']);
  }

}
