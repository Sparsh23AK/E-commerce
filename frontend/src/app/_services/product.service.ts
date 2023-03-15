import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl: String; 
  requestHeader = new HttpHeaders({ 'No-Auth': 'True' });
  public productDetail : any = {};
  
  constructor(private http: HttpClient) { 
   this.baseUrl = 'http://localhost:8080/api/';
  }  

  getProductByCategory(product_category: String): Observable<any> {  
    return this.http.get(`${this.baseUrl}`+`common/product-detail/${product_category}`, {
      headers: this.requestHeader,
    }); 
  }  

  setProductDetail(productDetail : any){
    this.productDetail = productDetail;
  }

  getProductDetail(){
    return this.productDetail;
  }


}
