import { AfterViewInit, Component, ElementRef } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements AfterViewInit {

  constructor(private elementRef: ElementRef) {}

  ngAfterViewInit(): void {

    const elements = this.elementRef.nativeElement
      .querySelectorAll('.reveal, .reveal-reverse');

    const observer = new IntersectionObserver(
      (entries) => {

        entries.forEach(entry => {

          if (entry.isIntersecting) {

            entry.target.classList.add('show');

           
            observer.unobserve(entry.target);
          }

        });

      },
      {
        threshold: 0.15
      }
    );

    elements.forEach((element: Element) => {
      observer.observe(element);
    });
  }
}