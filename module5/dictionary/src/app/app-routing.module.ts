import { DictionaryPageComponent } from './dictionary-page/dictionary-page.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DiictionaryDetailsComponent } from './diictionary-details/diictionary-details.component';


const routes: Routes = [{
  path:'',component: DictionaryPageComponent
},
{
  path:'detail/:word',component: DiictionaryDetailsComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
 }
