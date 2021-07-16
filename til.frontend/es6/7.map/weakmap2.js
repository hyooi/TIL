//인스턴스 변수 캡슐화하기1
const wm = new WeakMap();
function Area(height, width) {
  wm.set(this, {height, width});
}

Area.prototype.getArea = function () {
  const {height, width} = wm.get(this);
  return height * width;
}

let myArea = new Area(10, 20);
console.log(wm.get(myArea));
console.log(myArea.getArea());
console.log(myArea.height); //접근불가능!

myArea = null;
console.log(wm.get(myArea)); //weakmap이므로 가비지컬렉션

//인스턴스 변수 캡슐화하기2
const obj = {};
function Area2(height, width) {
  obj.height = height;
  obj.width = width;
}

Area2.prototype.getArea = function () {
  return obj.height * obj.width;
}
let myarea2 = new Area2(10,20);
console.log(myarea2.getArea());