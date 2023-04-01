import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";
import {Product} from "../../models/Product";

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  createProductForm : FormGroup;
  constructor(private service : ProductService,private router :Router) {
    this.createProductForm = new FormGroup({
      id : new FormControl(''),
      name : new FormControl(),
      price : new FormControl(),
      description : new FormControl()
    })
  }

  ngOnInit(): void {
  }

  create() {
    this.service.create(this.createProductForm.value).subscribe(()=>{
      this.router.navigateByUrl('products')
        console.log(this.createProductForm.value)
    }
    )

  }
}
