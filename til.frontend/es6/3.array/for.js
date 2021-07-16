var data= [1,2, undefined, NaN, null, ""];

// for-loop
console.log("1. for-loop:")
for (var i=0; i < data.length; i++) {
  console.log(i);
}

console.log("\n\n2. foreach:")
data.forEach(function (value) {
  console.log("value is: ", value);
})

console.log("\n\n3. for-in:")
Array.prototype.getIndex = function () {};

// for-in은 자기 자신이 아닌 상위에 추가된 객체까지 가지고 옴.
// 따라서 쓰지 않는 것을 추천
for(let idx in data) {
  console.log(data[idx]);
}

console.log("\n\n4. for-of:")
for(let value of data) {
  console.log(value);
}

console.log("\n\n5. for-of:")
for(let value of "test!") {
  console.log(value);
}