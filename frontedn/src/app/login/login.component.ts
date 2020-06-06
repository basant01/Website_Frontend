import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';
import { User } from '../user';
import { NgForm } from '@angular/forms';
import { from } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User();
  message='';

  constructor(private _service : RegistrationService, private _route : Router) { }

  ngOnInit(): void {
  }


  loginUser()
  {
    this._service.loginUserFromRemote(this.user).subscribe
    (
      data =>{console.log("response received");
      this._route.navigate(['/studentloginsucess'])
    },
      error=>
      {
        console.log("exception occured");
       this.message="Bad Credentials, Please enter Valid emailId and Password";
      

  }
    )
  }
}
