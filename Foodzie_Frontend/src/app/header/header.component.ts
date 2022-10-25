import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import {UserAuthService} from '../services/user-auth.service';
import { CartService } from '../services/cart.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  cartQuantity=0;
  constructor(
    private userAuthService: UserAuthService,
    private router: Router,
    public userService: UserService,
    cartService:CartService

  ) { 
    cartService.getCartObservable().subscribe((newCart) => {
      this.cartQuantity = newCart.totalCount;
    })
  }

  ngOnInit(): void {
  }

  public isLoggedIn() {
    return this.userAuthService.isLoggedIn();
    
  }

  public logout() {
    this.userAuthService.clear();
    this.router.navigate(['/home']);

  }
  

}
