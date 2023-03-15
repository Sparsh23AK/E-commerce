import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../_services/product.service';
import { faTag } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent {

  productDetail : any;
  isDataSourceAvailable : boolean = false;
  faTag = faTag;

  constructor(private route: ActivatedRoute, public productService : ProductService){}

  ngOnInit(): void {
      // this.route.queryParams.subscribe(params => {
      //   this.productDetail = JSON.parse(params["productDetail"]);
      // });
      this.productDetail = this.productService.getProductDetail();
      console.log(this.productDetail);
      this.isDataSourceAvailable = true;
  }
}
