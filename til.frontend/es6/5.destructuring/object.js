let obj = {
  name: "crong",
  address: "korea",
  age: 10
}

let {name, age} = obj;
console.log(name, age);

let {name: myName, age: myAge} = obj;
console.log(myName, myAge);

const deepObject = {
  state: {
    information: {
      name2: 'hyoin',
      languages: ['korean', 'english']
    }
  },
  value: 5
};

const {
  state: {
    information: {name2, languages}
  }, value
} = deepObject

console.log({name2, languages, value})
