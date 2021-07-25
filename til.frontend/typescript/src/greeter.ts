class Student {
  fullName: string;
  // public: 해당 인수의 이름으로 프로퍼티를 자동 생성함
  constructor(public firstName: string, public middleInitial: string,
              public lastName: string) {
    this.fullName = firstName + " " + middleInitial + " " + lastName;
  }
}

interface Person {
  firstName: string,
  lastName: string;
}

function greeter(person: Person) {
  return "Hello, " + person.firstName + " " + person.lastName;
}

let user = new Student("Jane", "M", "User");
document.body.textContent = greeter(user);