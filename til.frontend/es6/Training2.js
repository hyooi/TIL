const SETTING = {
  name : "LUCKY LOTTO!",
  count : 6,
  maxNumber : 45
}

const colorSet = new Set();
function getRandomNumber(maxNumber) {
  colorSet.add(Math.floor(Math.random() * maxNumber));
}

for(let i=0; i<SETTING.count; i++) {
  getRandomNumber(SETTING.maxNumber);
}
console.log(colorSet.values());