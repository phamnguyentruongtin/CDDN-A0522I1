import { IDictionary } from './../models/IDictionary';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  
  dictionaries : IDictionary [] = []



  constructor() { 
    this.dictionaries.push({word : 'book',mean : 'sách'})
    this.dictionaries.push({word : 'cat',mean : 'mèo'})
    this.dictionaries.push({word : 'dog',mean : 'chó'})
    this.dictionaries.push({word : 'bird',mean : 'chim'})
    this.dictionaries.push({word : 'change',mean : 'thay đổi,cơ hội'})
    this.dictionaries.push({word : 'bridge',mean : 'cầu'})
    this.dictionaries.push({word : 'God',mean : 'chúa'})
    this.dictionaries.push({word : 'sky',mean : 'trời'})
    this.dictionaries.push({word : 'pen',mean : 'bút'})
    this.dictionaries.push({word : 'shop',mean : 'cửa hàng'})
    this.dictionaries.push({word : 'life',mean : 'sự sống'})
    this.dictionaries.push({word : 'manager',mean : 'người quản lí'})
    this.dictionaries.push({word : 'check',mean : 'kiểm tra'})
    this.dictionaries.push({word : 'house',mean : 'nhà'})
    this.dictionaries.push({word : 'family',mean : 'gia đình'})
    this.dictionaries.push({word : 'brain strom',mean : 'đônhj não'})
    this.dictionaries.push({word : 'object',mean : 'đối tượng'})

  }
  getAll() {
      return this.dictionaries
  }
  findByWork(value : String){
    let dicResult : IDictionary
   for(let dic of this.dictionaries){
    if(dic.word === value){
      dicResult = dic
    }
   }
   return  dicResult;
  }
}
