/*
함수타입(function type)
 */

interface SearchFunc {
  (source: string, subString: string): boolean; //함수타입 기술 가능
}

let mySearch: SearchFunc;
mySearch= function (source: string, substring: string) {
  let result = source.search(substring);
  return result > -1;
}

//위 예제와 동일함
mySearch= function (src: string, sub: string): boolean {
  let result = src.search(sub);
  return result > -1;
}

//타입을 지정하지 않으면 추론하게됨
mySearch = function (src, sub) {
  return src.search(sub) > -1;
}

//그러나 반환 타입이 다르면 에러 발생
mySearch = function (src, sub) {
  return "string"
}