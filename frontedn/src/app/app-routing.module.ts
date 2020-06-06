import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { StudentloginsucesssComponent } from './studentloginsucesss/studentloginsucesss.component';


const routes: Routes = [

  {path:'',component:LoginComponent},
  {path:'studentloginsucess',component:StudentloginsucesssComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
