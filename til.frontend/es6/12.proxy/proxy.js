const myObj = {name: 'crong'};
const proxy = new Proxy(myObj, {
  // target: myObj, receiver : proxy객체
  get : (target, p, receiver) => {
    console.log("get value");
    // return target[p] + '(get)';
    return (p in target)? Reflect.get(target, p) : "anonymous"; //위의 방법보다 reflect를 권장
  },
  set : (target, p, value, receiver) => {
    console.log('change value');
    target[p] = value + '(set))';
  }
});

console.log("proxy.name: ", proxy.name);
proxy.name = "hyoin";

console.log(myObj);
console.log(proxy.asd);