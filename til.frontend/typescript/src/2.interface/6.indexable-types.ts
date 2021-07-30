/*
인덱서블 타입
- 문자열 및 숫자만 인덱서를 지원
 */
interface StringArray {
  [index: number]: string; //number로 인덱싱하며, string을 반환할 것
}

let myArray: StringArray;
myArray = ["bob", "fred"];

let myStr: string = myArray[0]

class Animal {
  name: string;
}

class Dog extends Animal {
  breed: string;
}

//두 타입의 인덱서를 지원하는 경우, string타입 변환 후 number로 변환하게됨. ex) temp[100] -> temp["100"]
//따라서 number로 반환된 타입은 문자열 반환타입의 하위 타입이어야 함!
interface NotOkay {
  // 이렇게하면 에러임
  // [x: number]: Animal;
  // [x: string]: Dog;

  //이건 정상!
  [x: number]: Dog;
  [x: string]: Animal;
}

interface NumberDictionary {
  [index: string]: number;
  length: number;
  name: string; //name이 인덱서의 하위타입이 아니므로 에러
}

// index가 number, string둘다 가능하므로 에러X
interface NumberDictionary2 {
  [index: string]: number | string;
  length: number;
  name: string;
}

interface ReadonlyStringArray {
  readonly [index: number]: string;
}

let myArray: ReadonlyStringArray = ["Alice", "bob"];
myArray[2] = "allory"; //읽기전용이라 에러임