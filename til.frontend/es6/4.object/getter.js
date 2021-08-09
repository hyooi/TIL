const numbers = {
  _a: 1,
  b: 2,
  get sum() {
    return this._a + this.b;
  },
  set a(value) {
    console.log('set a!')
    this.a = value;
  }
};


console.log(numbers.sum)
numbers._a = 3;
console.log(numbers.sum)
