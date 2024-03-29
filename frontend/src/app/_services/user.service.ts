import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  API_PATH = 'http://flipzonsghc-env.eba-p8mbe2mf.ap-northeast-1.elasticbeanstalk.com';
  // API_PATH = 'http://localhost:8080';

  requestHeader = new HttpHeaders({ 'No-Auth': 'True' });

  constructor(
    private httpclient: HttpClient,
    private userAuthService: UserAuthService
  ) {}

  public login(loginData: any) {
    return this.httpclient.post(this.API_PATH + '/authenticate', loginData, {
      headers: this.requestHeader,
    });
  }

  public register(registerNewUserData: any) {
    return this.httpclient.post(
      this.API_PATH + '/registerUser',
      registerNewUserData,
      { headers: this.requestHeader }
    );
  }

  public validateUserName(user_name : string) {
    return this.httpclient.get(
      this.API_PATH + `/validateUserName/${user_name}`,
      { headers: this.requestHeader }
    ); 

  }

  public roleMatch(allowedRoles: any): boolean{
      let isMatch = false;
      const userRoles: any = this.userAuthService.getRoles();

      if (userRoles != null && userRoles) {
        for (let i = 0; i < userRoles.length; i++) {
          for (let j = 0; j < allowedRoles.length; j++) {
            if (userRoles[i].roleName === allowedRoles[j]) {
              isMatch = true;
            } 
          }
        }
      }
      return isMatch;
  }



}
