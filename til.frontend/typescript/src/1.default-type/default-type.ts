/********** 불리언 **********/
let isDone: boolean = false;


/********** 숫자 **********/
let decimal: number = 6;
let hex: number = 0xf00d;
let binary: number = 0b1010;
let octal: number = 0o744;


/********** 문자열 **********/
let color: string = "blue";
color = 'red';

let fullName: string = `Bob bobbinbton`;
let age: number = 37;
let sentence: string = `Hello, my name is ${fullName}.` //템플릿 문자열로 표현식 포함 가능


/********** 배열 **********/
let list: number[] = [1,2,3];
let list2: Array<number> = [1,2,3]; //제네릭 배열 타입


/********** 튜플 **********/
let x: [string, number];
x = ["hello", 10];
// x = [10, "hello"]; //오류

console.log(x[0].substring(1));
// console.log(x[1].substring(1)); //오류
// console.log(x[5].toString); //오류


/********** 열거: 0부터 시작해 멤버들의 번호를 매김 **********/
enum Color {Red=1, Green, Blue}
let c: Color = Color.Green;
let colorName: string = Color[2];
console.log(colorName);


/********** Any. object에도 어떤 값이든 할당할 수 있지만, 런타임 때 존재하는 메서드를 호출할 수는 없음 **********/
let notSure: any = 4;
notSure = "maybe a string instead";
notSure = false;
notSure.ifItExists();

let prettySure: Object = 4;
// prettySure.toFixed(); //오류

// 여러 타입이 섞인 배열을 다룰 수 있음
let list3: any[] = [1, true, "free"];
list[1] = 100;


/**********  Void **********/
function warnUser(): void {
  console.log("This is my warning message.")
}

// void로 타입변수를 선언하는 것은 권장되지 않음.
let unusable: void = undefined;
unusable = null; //stringNullChecks를 사용하지 않는 경우에만 가능


/********** Null and Undefined **********/
// 이 외의 값은 u와 n엔 할당 불가
// strictNullChecks사용 시엔 사용 불가능함
let u: undefined = undefined;
let n: null = null;


/********** Never: 절대 발생할 수 없는 타입을 나타냄  **********/
function error(message: string): never {
  throw new Error(message);
}

function fail() { // 반환 타입이 never
  return error("Something failed");
}

function infiniteLoop(): never { //함수 종료 불가
  while(true) {

  }
}


/********** 객체: primitive가 아닌 타입 **********/
declare function create(o: object | null) : void;

create({ props: 0});
create(null);

// create(42); //오류
// create("string"); // 오류


/********** Type assertions **********/
// 타입스크립트는 개발자가 필요한 검사를 수행했다고 인지함.
// 다른 언어의 형변환과 유사하나, 다른 검사를 하지 않음

// angle-bracket문법
let someValue: any = "this is a string";
let strLength: number = (<string>someValue).length;

// as문법
let strLength2: number = (someValue as string).length;
