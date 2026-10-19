import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HallCategoriesComponent } from './hall-categories.component';

describe('HallCategoriesComponent', () => {
  let component: HallCategoriesComponent;
  let fixture: ComponentFixture<HallCategoriesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HallCategoriesComponent]
    });
    fixture = TestBed.createComponent(HallCategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
