import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';  
import { Observable } from 'rxjs'; 

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl: String; 
  
  constructor(private http:HttpClient) { 
   this.baseUrl = 'http://localhost:8080/api/';
  }  
  
  getProductList(): Observable<any> {  
    return this.http.get(`${this.baseUrl}`+'students-list');  
  }  
  
  saveProduct(product: object): Observable<object> {  
    return this.http.post(`${this.baseUrl}`+'products/save', product);  
  }  

  uploadImage(file : File, productId : number){
    const data: FormData = new FormData();
    data.append('image', file);
    return this.http.post(`${this.baseUrl}`+`products/images/${productId}`, data);  
  }
  
  
}
