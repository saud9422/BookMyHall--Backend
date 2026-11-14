import { DecimalPipe, Time } from "@angular/common";
import { hallImage } from "./save_hall";

export interface Dashboard{
    user:User,
    halls:Halls,
    bookings : Bookings[];
}

export interface User{
    name: string,
    email:string,
    password:string,
    address:string,
    phone:number
    createdOn:Date
    role:String
}

export interface Bookings{
    Id : Number,
    bookingType : string,
    bookingStatus : string,
    bookingDate : Date,
    bookingStartDate : Date,
    bookingEndDate : Date,
    bookingStartTime : Time,
    bookingEndTime : Time,
    totalBookingHours : Number,
    bookingAmount : string,
    hallName : String,
    hallLocation : String

}
export interface Halls {
  id?: number;
  name: string;
  description?: string;
  location?: string;
  price_per_hour?: number;
  price_per_day?: number;
  capacity?: number;
  halltype?: String;
  images?: hallImage;
  created?: Date;
  updated?: Date;
}