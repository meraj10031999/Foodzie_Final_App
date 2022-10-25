import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { AuthGuard } from './auth/auth.guard';
import { UserService } from './services/user.service';
import { AuthInterceptor } from './auth/auth.intercepter';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { AddCategoryComponent } from './add-category/add-category.component';
import { AddfoodComponent } from './addfood/addfood.component';
import { CartPageComponent } from './cart-page/cart-page.component';
import { FoodPageComponent } from './food-page/food-page.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { SearchComponent } from './search/search.component';
import { TagComponent } from './tag/tag.component';
import { TitleComponent } from './title/title.component';
import { RegisterComponent } from './register/register.component';
import { TotalCategoryComponent } from './total-category/total-category.component';
import { TotalFoodComponent } from './total-food/total-food.component';
import { UserListComponent } from './user-list/user-list.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    HomeComponent,
    UserComponent,
    LoginComponent,
    ForbiddenComponent,
    AddCategoryComponent,
    AddfoodComponent,
    CartPageComponent,
    FoodPageComponent,
    NotFoundComponent,
    SearchComponent,
    TagComponent,
    TitleComponent,
    RegisterComponent,
    TotalCategoryComponent,
    TotalFoodComponent,
    AdminComponent,
    UserListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    },
    UserService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
