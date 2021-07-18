const healthObj = {
  showHealth : function () {
    console.log("오늘은 "+this.healthTime);
  }
}

//new가 아닌 방법으로 object생성 가능. 변수는 직접 지정해주어야 함
const myHealth = Object.create(healthObj);
myHealth.healthTime = "11:20";
myHealth.name = "crong";

console.log("myHealth:", myHealth);

//object assign
const myHealth2 = Object.assign(Object.create(healthObj), {
  healthTime: "11:20",
  name: "crong",
});
console.log("myHealth2:", myHealth2);

const preObj = {
  name: "crong",
  lastTime: "11:20",
};

//이전값을 그대로 쓰되, source2로 신규 값이 있으면 그것으로 대체함
const myHealth3 = Object.assign({}, preObj, {
  "lastTime": "12:30",
  "age": 99
});
console.log("myHealth3:", myHealth3);
console.log(preObj === myHealth3); //source2에 빈값을 넣어도 두 객체는 다름