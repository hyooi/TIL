/**
 * 함수 타이핑
 * - 파라미터와 함수의 리턴타입 지정이 가능.
 * - 리턴문을 보고 리턴타입 파악이 가능하므로 생략도 가능함
 */
function add(x: number, y: number): number {
  return x+y;
}

let myAdd = function (x: number, y: number): number {
  return x+y
};

/**
 * 함수 타입 작성
 */
let myAdd2: (x: number, y: number) => number =
    function (x: number, y:number): number {
      return x+y;
    };
