import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../_services/product.service';
import { faTag } from '@fortawesome/free-solid-svg-icons';
import { UserAuthService } from '../_services/user-auth.service';
@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent {
  productDetail : any;
  isDataSourceAvailable : boolean = false;
  faTag = faTag;
  loggedInUser: any = null;
  constructor(private route: ActivatedRoute,
    public productService : ProductService,
    public userAuthService : UserAuthService,
    private router : Router
    ){
      this.loggedInUser = this.userAuthService.getLoggedInUserDetail();
      console.log(this.loggedInUser);
    }
  ngOnInit(): void {
      // this.route.queryParams.subscribe(params => {
      //   this.productDetail = JSON.parse(params["productDetail"]);
      // });
      this.productDetail = this.productService.getProductDetail();
      console.log(this.productDetail);
      this.isDataSourceAvailable = true;
  }
  
  addToCart(data : any , isBuyOnly : boolean) {
    if(this.userAuthService.isLoggedIn()){
      const cartDetails = {
        'userName' : this.loggedInUser.userName,
        'productId' : data.productId,
        'quantity' : 1
      }
      this.productService.addToCart(cartDetails).subscribe(
        res => {
          console.log(res);
          if(isBuyOnly){
            this.router.navigate(['/cart']);
          }
        }
      )
    }
    else{
      this.router.navigate(['/login']);
    }
  }
}