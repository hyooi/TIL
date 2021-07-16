let mySet = new Set();
console.log(toString.call(mySet));

mySet.add("crong");
mySet.add("hary");
mySet.add("crong");

console.log(mySet);
console.log(mySet.has("crong"));
console.log(mySet.has("test"));

mySet.delete("crong");
console.log(mySet);