let num : number = 100;
let n1 : number = 1;
let n2 : number = 2;
let fibonaci = 0;
let sum = 0;

for (let i = 0;i<=num;i++){
    fibonaci = n1 + n2;
    n1 = n2
    n2 = fibonaci;
    sum +=fibonaci

}
console.log(sum)