/*
spread operator(펼침연산자)
: concat처럼 기존 데이터를 복제해 새로 생성
 */
let pre = ["apple", "orange", 100];
let newData = [...pre];
console.log(pre, newData);
console.log(pre === newData);

let pre2 = [100, 200, "hello", null];
let newData2 = [0,1,2,3,4, ...pre, 4];
console.log(pre2, newData2);

function sum(a,b,c) {
  return a+b+c;
}

const data = [100, 200, 300];
console.log(sum.apply(null, data));
console.log(sum(...data))

/**
 * indexOf: 데이터가 몇번째에 있는지 찾기(숫자, 문자열, 불리언만 가능)
 */
console.log('data.indexOf(200):')
console.log(data.indexOf(200))

/**
 * findIndex: 데이터가 몇번째에 있는지 찾기(배열, 객체인 경우 가능)
 */
const data2 = [{id:1}, {id:2}, {id:3}]
console.log('data.findIndex(data => data.id ===3):')
console.log(data2.findIndex(data => data.id ===3))

/**
 * find: findIndex와 비슷하나 찾아낸 값을 반환
 */
console.log('data.find(data => data.id ===3):')
console.log(data2.find(data => data.id === 3));

/**
 * filter: 조건 만족하는 값들을 추출하여 신규 배열로 만듦
 */
console.log('data.filter(data => data.id ===3):')
console.log(data2.filter(data => data.id === 3));

/**
 * splice: 배열에서 특정 항목 제거
 */
data2.splice(2,1)
console.log(data2)

/**
 * slice: 기존의 배열은 건들지 않고 배열 항목 제거
 */
const data3 = data2.slice(0,1)
console.log(data3)

/**
 * shift: 첫번째 원소 추출
 * pop: 마지막 원소 추출
 * unshift: 첫번째에 원소 추가
 */
console.log(data2.shift());
console.log(data2.pop());
data2.unshift({id: 0})

/**
 * concat: n개 이상의 배열을 하나로 합침
 * join: 배열 내부 값들을 문자열로 합침
 */
const arr1 = [1,2,3];
const arr2 = [4,5,6];
console.log(arr1.concat(arr2));

console.log(arr1.join(','));

/**
 * reduce: 누적값 구하기 용이
 * 첫번째 파라미터는 결과를 반환하는 콜백함수, 두번째는 초기값
 */
console.log(arr1.reduce((acc, cur) => {
  return acc + cur;
}, 0))
