import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from "../models/order"
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VentasService {

  constructor(private http:HttpClient) {

  }


  public getAll(): Observable<any>  {
    return this.http.get("http://localhost:8080/ventas");
  }

  public delete(id: number): Observable<any> {
    return this.http.delete("http://localhost:8080/ventas/" + id)
  }

  public modify(id:any, object: Order): Observable<any> {
    console.log(id);
    
    return this.http.put("http://localhost:8080/ventas/" + id, object)
  }

  public add(object: Order):  Observable<any> {
    return this.http.post("http://localhost:8080/ventas", object)
  }

  public getFirsts(): Observable<any>  {
    return this.http.get("http://localhost:8080/ventas/first");
  }

}
