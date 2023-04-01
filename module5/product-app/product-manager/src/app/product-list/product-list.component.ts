import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../models/Product";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products : Product[] = []
  constructor(private productService : ProductService,private router : Router) {

  }

  ngOnInit(): void {
    this.showList();
    console.log(this.showList())
  }

  showList(){
    this.productService.getAll().subscribe(next =>{
      this.products = next
    })
  }
  delete(id : number) {
    this.productService.delete(id).subscribe( () => {
      this.ngOnInit()
    });
  }
}
