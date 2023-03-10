import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
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

    hide = true;
    email = new FormControl('', [Validators.required, Validators.email]);

    getErrorMessage() {
      if (this.email.hasError('required')) {
        return 'You must enter a value';
      }
  
      return this.email.hasError('email') ? 'Not a valid email' : '';
    }

  register(registerForm:any){
    var data = {
      'userName' : registerForm.value.userName,
      'firstName' : registerForm.value.firstName,
      'lastName' : registerForm.value.lastName,
      'userPassword' : registerForm.value.userPassword,
      'email' : this.email.value
    }
    this.userService.register(data).subscribe(
      (response)=>{
        this.router.navigate(['/login']);
        console.log(response);
      },
      (error) =>{
        console.log(error);
      }
    )
  }

}
