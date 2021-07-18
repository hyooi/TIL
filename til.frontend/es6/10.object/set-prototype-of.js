// parent
const healthObj = {
  showHealth : function () {
    console.log("오늘 운동시간 : ", this.healthTime);
  },

  setHealth : function (newTime) {
    this.healthTime = newTime;
  }
}

const newObj = Object.setPrototypeOf({
  name: "crong",
  lastTime : "11:20"
}, healthObj);
console.log("my health is", newObj);

const healthChildObj = {
  getAge: function () {
    return this.age;
  }
}

//프로토타입 체인을 이용해 healthObj에 healthChildObj를 할당함.
//상속처럼 사용 가능
Object.setPrototypeOf(healthChildObj, healthObj);
const childObj = Object.setPrototypeOf({
  age: 22
}, healthChildObj);
childObj.setHealth("11:55");
