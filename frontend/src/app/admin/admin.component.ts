import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { AdminService } from '../_services/admin.service';
import { ProductService } from '../_services/product.service';
import { faEdit } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  addProductAdminFormControl = new FormGroup({
    productCategory : new FormControl(),
    description : new FormControl(),
    subDescription : new FormControl(),
    price : new FormControl(),
    discountPercentage : new FormControl(),
    size : new FormControl(),
    type : new FormControl(),
    rating : new FormControl()
  });

 

  displayedColumns: string[] = ['orderId','userName', 'phNumber', 'address', 'orderAmount', 'orderStatus', 'action'];
  datasource : any[] =[];
  faEdit = faEdit;
  
  selectedFile!: File;
  currentProductId!: number;

constructor(private adminService : AdminService , private productService: ProductService) { }

ngOnInit() {
  this.getAllOrders();
  }

  onAddProductSubmit(){
    console.log('addProductAdminFormControl' , this.addProductAdminFormControl.value);
    this.adminService.saveProduct(this.addProductAdminFormControl.value).subscribe(
      (response :any) => {
        console.log(response, " from add product");
        this.currentProductId = response.productId;
        this.uploadImage(this.currentProductId);
        this.addProductAdminFormControl.reset();
      },
      (err : any) =>{
        console.log("Error while processing, Description : " , err);
      }
    )

  }

  onFileSelect(input : any){
    console.log(input.files[0]);
    this.selectedFile = input.files[0];
    }

  uploadImage(productId : number){
    this.adminService.uploadImage(this.selectedFile, productId).subscribe(
      (response : any) =>{
        console.log(response)
      }
    );
  }

  getAllOrders(){
    this.productService.getAllOrderDetails().subscribe(
      res =>{
        this.datasource = res;
        console.log(this.datasource);
      }, err =>{
        console.log(err);
      }
    )
  }

  changeOrderStatus(status: any, orderDetail: any){

    let data ={
      'orderId' : orderDetail.orderId,
      'orderStatus' : status
    }
    
    this.productService.changeOrderStatus(data).subscribe(
      res =>{
        console.log(res);
        this.getAllOrders();
      }
    )
  }



}
