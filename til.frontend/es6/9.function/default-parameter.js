function sum(value=2, size) {
  size = size || 1;
  return value + size;
}

function sum2(value, size={value:1}) {
  return value + size.value;
}

console.log(sum(3, 10)); //기본 요청
console.log(sum(3));
console.log(sum());

console.log(sum2(3, {value:3}));
console.log(sum2(3));