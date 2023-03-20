import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../_services/product.service';
import { UserAuthService } from '../_services/user-auth.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent {
  loggedInUser: any;
  datasource: any = [];
  dataForOrder: any = [];
  isDataAvailable: boolean = false;
  title: String = "";
  displayedColumns: string[] = ['productId', 'productDescription', 'quantity', 'price', 'action'];


  constructor(private router: Router,
    public productService: ProductService,
    public userAuthService: UserAuthService
  ){
    this.loggedInUser = this.userAuthService.getLoggedInUserDetail();
    this.title = this.loggedInUser.userName;
  }

  ngOnInit() {
    this.getOrderDetails();
  }

  getOrderDetails(){
    this.productService.getOrderDetails(this.title).subscribe(
      res => {
        console.log(res, "order Details");
      }
    )
  }
}
