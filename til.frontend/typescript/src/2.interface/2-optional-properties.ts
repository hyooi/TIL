// optional properties: 선언 시 이름 끝에 ?를 붙임
// SquareConfig interface 중 일부만 채워 사용 가능
// 그러나 property명을 잘못 기술한 경우 컴파일 에러 발생시킴
interface SquareConfig {
  color?: string;
  width?: number;
}

function createSquare(config: SquareConfig): {color: string; area: number} {
  let newSquare = {color: "white", area: 100};
  if(config.color) {
    newSquare.color = config.color;
  }

  if(config.width) {
    newSquare.area = config.width * config.width;
  }

  return newSquare;
}

let mySquare = createSquare({color: "black"});
console.log(mySquare)