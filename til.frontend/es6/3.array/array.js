/*
spread operator(펼침연산자)
: concat처럼 기존 데이터를 복제해 새로 생성
 */
let pre = ["apple", "orange", 100];
let newData = [...pre];
console.log(pre, newData);
console.log(pre === newData);

let pre2 = [100, 200, "hello", null];
let newData2 = [0,1,2,3,4, ...pre, 4];
console.log(pre2, newData2);

function sum(a,b,c) {
  return a+b+c;
}

const data = [100, 200, 300];
console.log(sum.apply(null, data));
console.log(sum(...data))