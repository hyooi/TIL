/*
weakset
- 참조를 가지고 있는 객체만 저장이 된다.
- 객체를 중복없이 저장하고자 할 때 사용
 */
let arr = [1,2,3,4];
let arr2 = [5,6,7,8];

let obj = {arr, arr2};
let ws = new WeakSet();

ws.add(arr);
ws.add(arr2);
ws.add(obj);

console.log(ws);
console.log(ws.has(arr));

/*
arr를 null로 변경한 뒤엔, weakset에선 가지고 있는것처럼 보이나,
가비지 컬렉션 대상이 되었으므로 has했을 땐 false가 된다.
 */
arr = null;
console.log(ws);
console.log(ws.has(arr));
