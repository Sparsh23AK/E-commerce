import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../_services/product.service';
import { UserAuthService } from '../_services/user-auth.service';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {
  cartDetails: any;
  loggedInUser: any;
  datasource: any = [];
  dataForOrder: any = [];
  isDataAvailable: boolean = false;
  title: String = "";
  displayedColumns: string[] = ['productId', 'productDescription', 'quantity', 'price', 'action'];
  constructor(private router: Router,
    public productService: ProductService,
    public userAuthService: UserAuthService
  ) {
    this.loggedInUser = this.userAuthService.getLoggedInUserDetail();
    console.log(this.loggedInUser);
    this.title = this.loggedInUser.userName;
  }
  ngOnInit() {
    this.getCartDetails();
  }
  deleteCartItem(cartId: any) {
    console.log(cartId);
    this.productService.deleteCartItem(cartId).subscribe(
      res => {
        this.getCartDetails();
      }, (err) => {
        console.log(err);
      }
    );
  }
  getCartDetails() {
    this.cartDetails = this.productService.getCartValueByUser(this.title).subscribe(
      res => {
        if (res.length != 0) {
          this.dataForOrder = res;
          this.datasource = this.productService.modifyCartDetails(res);
          this.isDataAvailable = true;
          console.log(this.datasource, "From cart")
        } else {
          this.isDataAvailable = false;
          this.datasource = res;
        }
      }
    );
  }
  configureItems(checkOutForm: any) {
    const productList : any[] = [];
    let orderAmount : number = 0.0;
    // const productQuantitySet : any[] =[];
    for(let i =0 ; i< this.dataForOrder.length ; i++){
      productList.push(this.dataForOrder[i].product);
      orderAmount = orderAmount + this.datasource[i].product.price;
      // const prodQuanSet = {
      //   'productId' : this.datasource[i].product.productId ,
      //   'quantity' : this.datasource[i].quantity
      // }
      // productQuantitySet.push(prodQuanSet);
    }
    console.log(orderAmount, "order amount from configure");
    console.log(productList, "product list  from configure");
    let data ={
      'userName' : this.title,
      'orderAmount' : orderAmount,
      'productList': productList,
      'address': checkOutForm.value.address,
      'phoneNumber': checkOutForm.value.phNumber
      // 'productQuantitySet': productQuantitySet,
    }
    this.productService.placeOrder(data).subscribe(
      res =>{
        console.log(res);
        this.router.navigate(['/orderDetails']);
      }
    );
  }
}