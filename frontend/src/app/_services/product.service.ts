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
   this.baseUrl = 'http://flipzonsghc-env.eba-p8mbe2mf.ap-northeast-1.elasticbeanstalk.com/api/';
  //  this.baseUrl = 'http://localhost:8080/api/';
  }  

  getProductByCategory(product_category: String): Observable<any> {  
    return this.http.get(`${this.baseUrl}`+`common/product-detail/${product_category}`, {
      headers: this.requestHeader,
    }); 
  }  

  getProductByCategoryHomePage(product_category: String): Observable<any> {  
    return this.http.get(`${this.baseUrl}`+`common/product-detail-forHomePage/${product_category}`, {
      headers: this.requestHeader,
    }); 
  }  

  setProductDetail(productDetail : any){
    this.productDetail = productDetail;
  }

  getProductDetail(){
    return this.productDetail;
  }

  addToCart(cartDetails : any){
    return this.http.post(`${this.baseUrl}`+'cart/addToCart', cartDetails);  
  }

  getCartValueByUser(user_name: String): Observable<any> {
    return this.http.get(`${this.baseUrl}`+`cart/getCart/${user_name}`);
  }

  modifyCartDetails(cartDetails: any[]){
    for(let i=0; i < cartDetails.length; i++){
      const price = cartDetails[i].product.price;
      const discPerc = cartDetails[i].product.discountPercentage;
      cartDetails[i].product.price = price - (price * discPerc) / 100;
    }
    return cartDetails;
  }

  deleteCartItem(cartId: any){
    return this.http.delete(`${this.baseUrl}`+`cart/deleteCartItem/${cartId}`);
  }

  placeOrder(orderDetail : any){
    return this.http.post(`${this.baseUrl}`+'order/placeOrder', orderDetail);
  }

  getOrderDetails(user_name: String): Observable<any>{
    return this.http.get(`${this.baseUrl}`+`order/getOrderDetails/${user_name}`);
  }


  getAllOrderDetails(): Observable<any>{
    return this.http.get(`${this.baseUrl}`+`order/getAllOrderDetails`);
  }

  changeOrderStatus(data : any){
    return this.http.post(`${this.baseUrl}`+`order/changeOrderStatus` , data); 
  }
}
