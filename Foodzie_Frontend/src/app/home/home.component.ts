import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Food } from '../model/Food';
import { FoodService } from '../services/food.service';
import { UserAuthService } from '../services/user-auth.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  foods: Food[] = [];
  constructor(private userAuthService: UserAuthService,
    private router: Router,
    public userService: UserService,
    private foodService: FoodService,
     activatedRoute: ActivatedRoute
    ) {
      activatedRoute.params.subscribe((params) => {
        if (params.searchTerm)
          this.foods = this.foodService.getAllFoodsBySearchTerm(params.searchTerm);
        else if (params.tag)
          this.foods = this.foodService.getAllFoodsByTag(params.tag);
        else
          this.foods = foodService.getAll();
      })
     }

  ngOnInit(): void {
  }
  public isLoggedIn() {
    return this.userAuthService.isLoggedIn();
  }

}
