// 불리언
var isDone = false;
// 숫자
var decimal = 6;
var hex = 0xf00d;
var binary = 10;
var octal = 484;
//문자열
var color = "blue";
color = 'red';
var fullName = "Bob bobbinbton";
var age = 37;
var sentence = "Hello, my name is " + fullName + "."; //템플릿 문자열로 표현식 포함 가능
//배열
var list = [1, 2, 3];
var list2 = [1, 2, 3]; //제네릭 배열 타입
//튜플
var x;
x = ["hello", 10];
// x = [10, "hello"]; //오류
console.log(x[0].substring(1));
// console.log(x[1].substring(1)); //오류
// console.log(x[5].toString); //오류
//열거: 0부터 시작해 멤버들의 번호를 매김
var Color;
(function (Color) {
    Color[Color["Red"] = 1] = "Red";
    Color[Color["Green"] = 2] = "Green";
    Color[Color["Blue"] = 3] = "Blue";
})(Color || (Color = {}));
var c = Color.Green;
var colorName = Color[2];
console.log(colorName);
