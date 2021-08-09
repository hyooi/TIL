function Health(name) {
  this.name = name;
}

Health.prototype.showHealth = function () {
  console.log(this.name + "님 안녕하세요");
}

const h = new Health("crong");
h.showHealth();

//사실 Health와 동일함. 내부 기능은 function과 동일. 가독성 면에서 유리함
class Health2 {
  constructor(name, lastTime) {
    this.name = name;
    this.lastTime = lastTime;
  }

  showHealth() { //Health2를 출력해보면, 결국 prototype안에 들어감
    console.log(this.name + "님 안녕하세요");
  }
}
new Health2("crong").showHealth();

class Health3 extends Health2 {
  constructor(name, lastTime) {
    super(name, lastTime);
  }
}
