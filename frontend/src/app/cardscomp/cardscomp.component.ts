import { Component, Input } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { ProductService } from '../_services/product.service';

@Component({
  selector: 'app-cardscomp',
  templateUrl: './cardscomp.component.html',
  styleUrls: ['./cardscomp.component.css']
})

export class CardscompComponent {

  @Input() datasource : any = [];
  @Input() categoryName : String ="";
  title : String = "";
  

  constructor(private router : Router , public productService : ProductService){  }

  ngOnInit(){
    this.title = this.datasource[0].productCategory;

  }
  viewProduct(data : any){
    console.log(data);
    // let navigationExtras: NavigationExtras = {
    //   queryParams: {
    //       "productDetail": JSON.stringify(data)
    //   }
    // };
    this.productService.setProductDetail(data);
    this.router.navigate(["/view-product"]);
  }

}
