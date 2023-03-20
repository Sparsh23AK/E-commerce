import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from '../_services/user-auth.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  hide = true;
  constructor(
    private userService: UserService,
    private userAuthService: UserAuthService,
    private router: Router
    ){}

  ngOnInit(): void {
      
  }
  
  login(loginForm: any){
    this.userService.login(loginForm.value).subscribe(
      (response:any)=>{
        this.userAuthService.setRoles(response.user.role);
        this.userAuthService.setToken(response.jwtToken); 
        this.userAuthService.setLoggedInUserDetail(response.user);
        const role = response.user.role[0].roleName;
        if(role === 'Admin'){
          this.router.navigate(['/admin']);
        } else{
          this.router.navigate(['/']);
        }
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  registerUser(){
    this.router.navigate(['/register']);
  }
}
