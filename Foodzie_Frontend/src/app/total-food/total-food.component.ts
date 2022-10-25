import { Component, OnInit } from '@angular/core';
import { FoodC } from '../model/food-c';
import { FoodService } from '../services/food.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-total-food',
  templateUrl: './total-food.component.html',
  styleUrls: ['./total-food.component.css']
})
export class TotalFoodComponent implements OnInit {
  user: FoodC;

  constructor(
    private foodService: FoodService
  ) { }

  ngOnInit(): void {
  }

  public getAllFood(){
    this.foodService.getAllFood().subscribe(
     data => console.log(data)
    ,
    (error: HttpErrorResponse) =>{
    
      console.log(error);
    });
      
      
    }
    

}
