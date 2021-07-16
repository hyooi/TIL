const myObj = {
  runTimeout() {
    setTimeout(() => {
      console.log(this === window);
      this.printData();
      }, 200);
  },

  printData() {
    console.log("hi codesquad!");
  }
}

myObj.runTimeout();