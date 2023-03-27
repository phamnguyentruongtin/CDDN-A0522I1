import { IDictionary } from './../models/IDictionary';
import { DictionaryService } from './../dictionary-service/dictionary.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-diictionary-details',
  templateUrl: './diictionary-details.component.html',
  styleUrls: ['./diictionary-details.component.css']
})
export class DiictionaryDetailsComponent implements OnInit {
  dictionaryDetail : IDictionary;

  constructor(private dictionaryService : DictionaryService,private active : ActivatedRoute) { 
    this.active.paramMap.subscribe(next =>{
      const work = next.get('word');
      this.dictionaryDetail = dictionaryService.findByWork(work)
    },error =>{

    },()=>{
      
    })
  }

  ngOnInit(): void {
  }

}
