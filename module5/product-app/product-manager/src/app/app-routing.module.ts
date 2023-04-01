import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from "./product-list/product-list.component";
import {CreateProductComponent} from "./create-product/create-product.component";
import {EditComponent} from "./edit/edit.component";


const routes: Routes = [
  {path : 'products',component : ProductListComponent},
  {path : 'products/create',component : CreateProductComponent},
  {path : 'products/edit:/id',component : EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
