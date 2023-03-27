import { Component, OnInit } from '@angular/core';
import { ImageService } from '../_services/image.service';
import { ProductService } from '../_services/product.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent {
  productList : any[] = [];
  categoryName : any;
  title : String = "";
  isProductListAvailable : boolean = false;
  menProduct : boolean = false;

  constructor(public productService : ProductService, 
    public imageService : ImageService,
    private activatedRoute : ActivatedRoute)
    {
    this.activatedRoute.params.subscribe(
      params => {
          this.categoryName = params['categoryName'];
          console.log(this.categoryName);
          this.title = this.categoryName;
          if(this.categoryName === "Men"){
            this.menProduct = true;
            this.getProductByMen();
            console.log(this.menProduct);
          }
          else if(this.categoryName === "Women"){
            this.getProductByWomen();
            this.menProduct = false;
          }
          else{
            this.title = "Something went wrong. Please try again."
          }
      }
    );
  }

  ngOnInit() {
  }


  getProductByMen(){
    this.productService.getProductByCategory("Men")
    .subscribe(
      res => {
        this.productList = this.imageService.createImage(res);
        this.isProductListAvailable = true;
      }
    );
  }
  getProductByWomen(){
    this.productService.getProductByCategory("Women")
    .subscribe(
      res => {
        this.productList = this.imageService.createImage(res);
        this.isProductListAvailable = true;
      }
    );
  }

}
