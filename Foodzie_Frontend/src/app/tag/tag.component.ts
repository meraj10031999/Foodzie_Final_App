import { Component, OnInit } from '@angular/core';
import { Tag } from '../model/tag';
import { FoodService } from '../services/food.service';

@Component({
  selector: 'app-tag',
  templateUrl: './tag.component.html',
  styleUrls: ['./tag.component.css']
})
export class TagComponent implements OnInit {
  tags?:Tag[];
  constructor(foodService:FoodService) {
    this.tags = foodService.getAllTags();
   }

  ngOnInit(): void {
  }

}
