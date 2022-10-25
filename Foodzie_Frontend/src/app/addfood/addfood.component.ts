import { Component, OnInit } from '@angular/core';
import { FoodC } from '../model/food-c';
import { NgForm } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { FoodService } from '../services/food.service';
import { HttpErrorResponse } from '@angular/common/http';
import { FileHandle } from '../model/file-handle-module';




@Component({
  selector: 'app-addfood',
  templateUrl: './addfood.component.html',
  styleUrls: ['./addfood.component.css']
})
export class AddfoodComponent implements OnInit {
  isSuccessful = false;
  isNotAdded = false;
  errorMessage = '';
  success='Food Added successfully';

  food : FoodC = {
    
    name : "",
    price : 0,
    favorite : false,
    cookTime : "",
    stars: 0 ,
    foodImages : []

  }

  constructor(
    private foodService: FoodService,
    private sanitizer : DomSanitizer,
  


  ) { }

  ngOnInit(): void {
  }
  addFood(addFoodForm : NgForm){
     const foodFormData =this.prepareFormData(this.food);

     this.foodService.addFood(foodFormData).subscribe(
      (response: FoodC) => {
        console.log(response);
        
        this.isSuccessful = true;
        this.isNotAdded = false;
        addFoodForm.reset();
      },
      (error: HttpErrorResponse) =>{
        this.isSuccessful = true;
        console.log(error);
        this.errorMessage = error.message;
        this.isNotAdded=true;
        
      }
      );
    
     
    }
    prepareFormData(food : FoodC): FormData{
      const formData=new FormData();
      formData.append(
      'food',
      new Blob([JSON.stringify(food)],{type :'application/JSON'})
      );
      

      for(var i=0;i<food.foodImages.length;i++){
        formData.append(
          'imageFile',

          food.foodImages[i].file,
          food.foodImages[i].file.name
        );
      }
        
        return formData;
      }
        
    

    // onFileSelected(event){
    //   if(event.target.files)
    //   const file = event.target.files[0];
       
    //     const fileHandle: FileHandle={
    //       file: file ,
    //       url : this.sanitizer.bypassSecurityTrustUrl(
    //         window.URL.createObjectURL(file)
    //       )}
    //       this.food.foodImages.push(fileHandle);
    //   }

  
    public onFileSelected(event) {
      if(event.target.files){
        const file = event.target.files[0];
       
        const fileHandle: FileHandle={
          file: file ,
          url : this.sanitizer.bypassSecurityTrustUrl(
            window.URL.createObjectURL(file)
          )}
          this.food.foodImages.push(fileHandle);
      }
           
    
      console.log(event);
  
    }  

}
