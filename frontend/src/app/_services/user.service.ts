import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  API_PATH = "http://localhost:8080";

  requestHeader = new HttpHeaders(
    { "No-Auth":"True"}
  );

  constructor(private httpclient: HttpClient) { }

  public login(loginData:any){
    return this.httpclient.post(this.API_PATH + "/authenticate", loginData, { headers: this.requestHeader});
  }
}
