//map: key/value
let wm = new WeakMap();
let myfun = function () {};

wm.set(myfun, 0);
console.log(wm.get(myfun));

let count=0;
for(let i=0; i<10; i++) {
  count = wm.get(myfun);
  count++;

  wm.set(myfun, count);
}
console.log(wm.get(myfun));

// weakmap이므로 참조가 없어지면 역시 가비지컬렉션 대상
myfun = null;
console.log(wm.get(myfun));
