import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../models/order';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }



  public getAll(): Observable<any>  {
    return this.http.get("http://localhost:8080/user");
  }

  public delete(id: number): Observable<any> {
    return this.http.delete("http://localhost:8080/user/" + id)
  }

  public modify(object: Order): Observable<any> {
    return this.http.put("http://localhost:8080/user", object)
  }

  public add(object: Order):  Observable<any> {
    return this.http.put("http://localhost:8080/userAdd", object)
  }



}
