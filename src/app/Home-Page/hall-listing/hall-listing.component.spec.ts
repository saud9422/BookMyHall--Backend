import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HallListingComponent } from './hall-listing.component';

describe('HallListingComponent', () => {
  let component: HallListingComponent;
  let fixture: ComponentFixture<HallListingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HallListingComponent]
    });
    fixture = TestBed.createComponent(HallListingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
