import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserAuthService {

  userDetail: any = null;

  constructor() {}

  public setRoles(roles: []) {
    sessionStorage.setItem('roles', JSON.stringify(roles));
  }

  public getRoles(): [] {
    return JSON.parse(sessionStorage.getItem('roles')!);
  }

  public setToken(jwtToken: string) {
    sessionStorage.setItem('jwtToken', jwtToken);
  }

  public getToken(): string {
    return sessionStorage.getItem('jwtToken')!;
  }

  public clear(){
    sessionStorage.clear();
  }

  public isLoggedIn(){
    return this.getRoles() && this.getToken();
  }

  public setLoggedInUserDetail(userDetail : []){
    sessionStorage.setItem('loggedInUserDetails', JSON.stringify(userDetail));
  }

  public getLoggedInUserDetail(){
    return JSON.parse(sessionStorage.getItem('loggedInUserDetails')!);
  }
}
