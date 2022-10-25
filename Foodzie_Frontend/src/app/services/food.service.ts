import { Injectable } from '@angular/core';
import { sample_foods, sample_tags } from 'src/data';
import { Tag } from '../model/tag';
import { Food } from '../model/Food';
import { HttpClient } from '@angular/common/http';
import { FoodC } from '../model/food-c';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  PATH_OF_API = 'http://localhost:7070';


  constructor(
    private httpclient: HttpClient


  ) { }

  getAll(): Food[] {
    return sample_foods;
  }

  getAllFoodsBySearchTerm(searchTerm: string) {
    return this.getAll().filter(food => food.name.toLowerCase().includes(searchTerm.toLowerCase()))
  }

  getAllTags(): Tag[] {
    return sample_tags;
  }

  getAllFoodsByTag(tag: string): Food[] {
    return tag === "All" ?
      this.getAll() :
      this.getAll().filter(food => food.tags?.includes(tag));
  }

  getFoodById(foodId:string):Food{
    return this.getAll().find(food => food.id == foodId) ?? new Food();
  }
  addFood(food : FormData){
    return this.httpclient.post<FoodC>(this.PATH_OF_API + '/addNewFood', food);

  }

  public getAllFood(): Observable<FoodC>{

    return this.httpclient.get<FoodC>(this.PATH_OF_API + '/getAllFood');

  }

}
