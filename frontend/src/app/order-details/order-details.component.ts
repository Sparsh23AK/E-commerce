import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../_services/product.service';
import { UserAuthService } from '../_services/user-auth.service';
import { faNoteSticky } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent {

  faNoteSticky = faNoteSticky;
  loggedInUser: any;
  datasource: any = [];
  dataForOrder: any = [];
  isDataAvailable: boolean = false;
  title: String = "";
  displayedColumns: string[] = ['orderId', 'address', 'orderAmount', 'orderStatus', 'action'];
  datasourceMl : any ;
  displayedColumnsModal: string[] = ['productId', 'productDescription', 'quantity', 'price'];

  isPlacedOdersAvailable : boolean = false;


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
        if(res.length != 0){
          this.datasource = res;
          this.isPlacedOdersAvailable = true;
        }
      }
    )
  }

  viewOrderDetails(data : any){
    for(let i =0 ; i < data.length ; i++){
      const dicPrice = data[i].price - (data[i].price * data[i].discountPercentage)/100 ;
      data[i].price = dicPrice;
    }
    this.datasourceMl = data;    
  }
}
