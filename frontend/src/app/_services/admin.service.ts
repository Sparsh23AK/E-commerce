import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';  
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private baseUrl: String; 
  
  constructor(private http:HttpClient) { 
   this.baseUrl = 'http://flipzonsghc-env.eba-p8mbe2mf.ap-northeast-1.elasticbeanstalk.com/api/';
  //  this.baseUrl = 'http://localhost:8080/api/';
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
