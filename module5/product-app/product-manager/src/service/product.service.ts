import {Injectable} from '@angular/core';
import {Product} from "../models/Product";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";



@Injectable({
  providedIn: 'root'
})
export class ProductService {


  constructor(private _httpClient: HttpClient) {
  }

  // @ts-ignore
  getAll(): Observable<Product[]> {
    return this._httpClient.get<Product[]>("http://localhost:3000/products")
  }

  findById(id: string) : Observable<Product> {
    return  this._httpClient.get("http://localhost:3000/products/" + id)
 }
 Edit(product : Product):Observable<any>{
    return this._httpClient.put("http://localhost:3000/products/",product)
 }

  // @ts-ignore
  delete(id: number): Observable<any> {
    const url = `http://localhost:3000/products/${id}`;
    return this._httpClient.delete<any>(url)
  }
  create(product :Product):Observable<any>{
    // @ts-ignore
    return this._httpClient.post("http://localhost:3000/products/" ,product)
  }

}
