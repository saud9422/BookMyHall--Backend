import { hallImage } from "./save_hall";

export interface Dashboard{
    user:User,
    halls:Halls
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