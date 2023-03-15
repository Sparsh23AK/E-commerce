import { Component } from '@angular/core';
import { ImageService } from '../_services/image.service';
import { ProductService } from '../_services/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  menProduct : any[] = [];
  womenProduct : any[] = [];
  isProductMenAvailable : boolean = false;
  isProductWomenAvailable : boolean = false;

  constructor(public productService : ProductService, public imageService : ImageService){
    this.getProductByMen();
  }

  ngOnInit() {
  }


  getProductByMen(){
    this.productService.getProductByCategory("Men")
    .subscribe(
      res => {
        this.menProduct = this.imageService.createImage(res);
        this.isProductMenAvailable = true;
      }
    );
  }
  getProductByWomen(){
    this.productService.getProductByCategory("Women")
    .subscribe(
      res => {
        this.womenProduct = this.imageService.createImage(res);
        this.isProductWomenAvailable = true;
      }
    );
  }

}
