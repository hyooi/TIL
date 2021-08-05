/**
 * 초과 프로퍼티 검사(Excess property checks)
 */
interface SquareConfig {
  color?: string;
  width?: number;
  [propName: string]: any; //또다른 프로퍼티를 가질 수 있음을 의미
}

function createSqaure(config: SquareConfig): { color: string; area: number } {
  return null
}

//colour가 SquareConfig에 없으므로 에러를 발생시킴(color와 width만 있는 경우!)
let mySquare = createSqaure({ colour: "red", width: 100})

//타입 단언을 통해 에러 회피 가능
createSqaure({ colour: "red", width: 100} as SquareConfig)

//혹은 오브젝트를 다른 변수에 할당하면, 추가 프로퍼티 검사를 회피할 수 있음
//그러나 width처럼 공통 프로퍼티가 있어야만 정상 작동. width가 없으면 에러!
const variable = { colour: "red", width: 100}
createSqaure(variable)
