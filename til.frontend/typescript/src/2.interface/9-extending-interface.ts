/**
 * 인터페이스 확장하기
 * - 한 인터페이스의 멤버를 다른 인터페이스에 복사 가능
 * - 인터페이스의 재사용성UP. 유연함 제공
 */

//멤버 복사!
interface Shape {
  color: string;
}

interface Square extends Shape {
  sideLength: number;
}

let square = {} as Square;
square.color = "blue";
square.sideLength = 10;


interface PenStroke {
  penWidth: number;
}

interface Square2 extends Shape, PenStroke {
  sideLength : number;
}

let square2 = {} as Square2;
square2.color = "blue";
square2.sideLength = 10;
square2.penWidth = 5.0;
