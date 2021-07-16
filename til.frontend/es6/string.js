//ES2015 string의 새로운 메서드
let str = "hello world ! ^^ ~~";
let matchstr = "hello";

console.log("str.startsWith(matchstr): " + str.startsWith(matchstr)); //특정문자열 시작?
console.log("str.endsWith(matchstr): " + str.endsWith(matchstr)); //특정문자열로 종료?
console.log("str.includes('el'): " + str.includes("el")); //매칭되는 문자열이 있는지?