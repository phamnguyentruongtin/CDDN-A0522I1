import { IDictionary } from './../models/IDictionary';
import { DictionaryService } from './../dictionary-service/dictionary.service';
import { Component, Inject, OnInit } from '@angular/core';

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
    dictionaryPage : IDictionary[] = []
  constructor(private dictionaryS :  DictionaryService) { 
      this.dictionaryPage = dictionaryS.getAll()
  }

  ngOnInit(): void {
  }

}
