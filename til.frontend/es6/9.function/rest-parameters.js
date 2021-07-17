// arguments를 써도 되지만, 진짜 배열을 만들어 쓰고 싶은 경우 ...argArray로 받을 수 있음
function checkNum(...argArray) {
  // const argArray = Array.prototype.slice.call(arguments);
  console.log(toString.call(argArray));

  //every: argArray가 모두 true이어야 true반환
  return argArray.every((v) => typeof v === "number");
}

const result = checkNum(10, 2, 3, 4, 5, "55");
console.log(result);