import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalCategoryComponent } from './total-category.component';

describe('TotalCategoryComponent', () => {
  let component: TotalCategoryComponent;
  let fixture: ComponentFixture<TotalCategoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TotalCategoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TotalCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
