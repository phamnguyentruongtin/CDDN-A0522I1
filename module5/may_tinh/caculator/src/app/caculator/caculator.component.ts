import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-caculator',
  templateUrl: './caculator.component.html',
  styleUrls: ['./caculator.component.css']
})
export class CaculatorComponent implements OnInit {
  result: number;

  constructor() { }

  ngOnInit(): void {
  }
  caculatorAction(num1, num2, action) {
   let Number1 = Number.parseFloat(num1);
   let Number2 = Number.parseFloat(num2);
    switch (action) {
      case "+":
        this.result = Number1 + Number2
        break;
      case "-":
        this.result = Number1 - Number2
        break;
      case "*":
        this.result = Number1 * Number2
        break;
      case "/":
        this.result = Number1 / Number2
        break;
      case "%":
        this.result = Number1 % Number2
        break;
    }

  }

}
