import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Observable,Subject } from "rxjs";  

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

constructor(private adminService : AdminService) { }

ngOnInit() {
  }

  onAddProductSubmit(){
    console.log('addProductAdminFormControl' , this.addProductAdminFormControl.value);
    this.adminService.saveProduct(this.addProductAdminFormControl.value).subscribe( {
      next: (v) => console.log(v),
      error: (e) => console.error(e),
      complete: () => console.info('complete') 
     })

  }

  onFileSelect(input : any){
    console.log(input.files);
    if (input.files && input.files[0]) {
      var reader = new FileReader();
      reader.onload = (e: any) => {
        console.log('Got here: ', e.target.result);
      }
     // reader.readAsDataURL(input.files[0]);
    }

  }
}
