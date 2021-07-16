setTimeout(function (){
  console.log("set timeout");
}, 1000);

setTimeout(() => {
  console.log("set timeout2");
}, 2000);

const newArr = [1,2,3,4,5].map((value) => value * 2);
console.log("arrow newArr", newArr);