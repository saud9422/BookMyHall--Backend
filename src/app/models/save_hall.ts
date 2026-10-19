
export interface save_hall {
  hall_id:number;
  name: string;
  description: string;
  halltype: string;
  capacity: number;
  address: string;
  price_per_hour: number;
  price_per_day: number;
  location: string;
  images?:hallImage[];
}

export interface hallImage{
  imagesdata : string;
}