import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { AdminService } from '../_services/admin.service';

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
  
  selectedFile!: File;
  currentProductId!: number;

constructor(private adminService : AdminService) { }

ngOnInit() {
  }

  onAddProductSubmit(){
    console.log('addProductAdminFormControl' , this.addProductAdminFormControl.value);
    this.adminService.saveProduct(this.addProductAdminFormControl.value).subscribe(
      (response :any) => {
        console.log(response, " from add product");
        this.currentProductId = response.productId;
        this.uploadImage(this.currentProductId);
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

}
