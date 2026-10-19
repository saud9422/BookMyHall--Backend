import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { FormControl, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './Home-Page/home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AboutComponent } from './Home-Page/about/about.component';
import { HallListingComponent } from './Home-Page/hall-listing/hall-listing.component';
import { HallCategoriesComponent } from './Home-Page/hall-categories/hall-categories.component';
import { FooterComponent } from './Home-Page/footer/footer.component';
import { HallFormComponent } from './hall-form/hall-form.component';
import { CustomerProfileComponent } from './dashbaord/customer-profile/customer-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    NavbarComponent,
    AboutComponent,
    HallListingComponent,
    HallCategoriesComponent,
    FooterComponent,
    HallFormComponent,
    CustomerProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
