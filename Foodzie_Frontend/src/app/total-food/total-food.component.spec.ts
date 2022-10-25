import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalFoodComponent } from './total-food.component';

describe('TotalFoodComponent', () => {
  let component: TotalFoodComponent;
  let fixture: ComponentFixture<TotalFoodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TotalFoodComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TotalFoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
