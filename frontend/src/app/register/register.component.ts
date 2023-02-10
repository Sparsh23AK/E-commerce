import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  constructor(
    private userService: UserService,
    private router: Router
    ) { }

  register(registerForm:any){
    console.log(registerForm);
    // this.userService.register(registerForm.value).subscribe(
    //   (response)=>{
    //     this.router.navigate(['/login']);
    //     console.log(response);
    //   },
    //   (error) =>{
    //     console.log(error);
    //   }
    // )
  }
}
