const name = "crong";
const age = 33;

const obj = {
  name : name,
  age : age
}
console.log(obj);

function getObj() {
  let name = "crong";
  const getName = function () {
    return name;
  }

  const setName = function (newname) {
    name = newname;
  }

  const printName = function () {
    console.log(name);
  }

  return {getName, setName, name};
}
console.log(getObj());

const dog = {
  name: '강아지',
  sound: '멍멍!',
  say: function() {
    //애로우 펑션으로 정의 시 this작동x. function함수여야 this가 자신이 속한 객체를 가리키므로
    console.log(this.sound);
  }
}

dog.say();
