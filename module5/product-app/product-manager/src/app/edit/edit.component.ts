import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";
import {Product} from "../../models/Product";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  formEdit : FormGroup
  product : Product
  constructor(private service:ProductService,private router : Router,private active : ActivatedRoute) {
    this.active.paramMap.subscribe(next =>{
      const id = next.get("id")
        this.service.findById(id).subscribe(next =>{
          this.product = next
          this.formEdit = new FormGroup({
            id : new FormControl(this.product.id),
            name : new FormControl(this.product.name),
            price : new FormControl(this.product.price),
            description : new FormControl(this.product.description)
          })
     })

    })
  }
  edit(){
    console.log(this.formEdit.value);
    this.service.Edit(this.formEdit.value).subscribe();
    this.router.navigateByUrl('products')
  }

  ngOnInit(): void {
  }

}
