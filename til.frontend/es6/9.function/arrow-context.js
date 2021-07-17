const myObj = {
  runTimeout() {
    //bind하지않으면 printData를 인식할 수 없음. this가 myObj를 가리키지 않으므로 bind해주어야 인식 가능!
    setTimeout(function () {
      this.printData();
      }.bind(this), 200);
  },

  //arrow function은 bind하지 않아도 접근 가능. 동일한 context를 유지하고 있으므로!
  runTimeout2() {
    setTimeout(() => {
      this.printData();
    }, 200);
  },

  printData() {
    console.log("hi!");
  }

}

myObj.runTimeout();
myObj.runTimeout2();