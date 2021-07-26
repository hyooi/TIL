//오브젝트 생성 시에만 수정 가능
interface Point {
  readonly x: number;
  readonly y: number;
}

let p1: Point = { x: 10, y: 20}
// p1.x = 5; //오류

let a: number[] = [1,2,3,4];
let ro: ReadonlyArray<number> = a;
// ro[0] = 12 //오류
// ro.push(5) //오류
// ro.length = 100 //오류
// a = ro //오류: ReadonlyArray는 일반 배열에 재할당이 불가함

// type assertion은 가능.
a = ro as number[]
console.log(a)