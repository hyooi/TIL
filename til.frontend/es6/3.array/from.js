// ES6 from method
function addMark() {
  let newArray = Array.from(arguments); // 배열같이 생겼지만 실제 배열이 아니었던 object를 배열로 변환함
  let newData = newArray.map(function (value) {
    return value + "!";
  })
  console.log(newData);
}

addMark(1,2,3,4,5);