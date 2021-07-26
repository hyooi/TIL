//size가 없지만, 타입스크립트는 최소한의 필요한 프로퍼티가 있는지와 타입이 맞는지만 검사함. 순서도 체크X
function printLabel(labeledObj: { label: string }) {
  console.log(labeledObj.label);
}

let myObj = {size: 10, label: "Size 10 Object"};
printLabel(myObj);

interface LabeledValue {
  label: string;
}

//LabeledValue interface의 프로퍼티는 모두 가지고 있어야 함
function printLabel2(labeledObj: LabeledValue) {
  console.log(labeledObj.label)
}
printLabel2(myObj)