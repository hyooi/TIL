var name = "global  var";

function home() {
    var homevar = "homevar";
    for(let i=0; i<100; i++) { // let: block scope내에서만 유효한 값
        // console.log(i);
    }

    if(true) {
        let myif = "myif";
        console.log(myif);
    }
}

//자바는 스코프 체인을 따라, function내에서 접근하는 경우 fuction내의 지역변수를 먼저 찾고, 없으면 전역변수를 찾는다.
//es6의 let은 block scope를 제공하므로 동일 block에서만 접근 가능하다.
home();
