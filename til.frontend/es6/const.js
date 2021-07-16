function home() {
  /*
  - const는 변경불가능(그러나 불변은 아니며, 값 재할당만 불가능해짐)
  - const를 기본적으로 쓰되, 필요한 경우에만 let사용
  - var는 사용하지 않는다.
   */
  const homename = [1,2,3,3];
  // homename = ["1","2"];

  console.log(homename);

  const list = ["apple", "orange", "watermelon"];
  list.push("banana"); // const를 사용하더라도, 배열 혹은 object의 값은 변경 가능하다.

  console.log(list);
}

//immutable array
const list = ["apple", "orange", "watermelon"];
list2 = [].concat(list, "banana");

console.log(list, list2);

home();

