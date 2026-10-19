import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './Home-Page/home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HallFormComponent } from './hall-form/hall-form.component';
import { CustomerProfileComponent } from './dashbaord/customer-profile/customer-profile.component';

const routes: Routes = [
  {path:'',component:RegisterComponent, data:{showNavbar: false}},
  {path:'login',component:LoginComponent, data:{showNavbar: false}},
  {path:'home',component:HomeComponent},
  {path:'navbar',component:NavbarComponent},
  {path:'addhall',component:HallFormComponent,data:{showNavbar: false}},
  {path:'dashboard/consumer',component:CustomerProfileComponent,data:{showNavbar: false}}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
