/**
 * 클래스의 스태틱과 인스턴스
 */

interface ClockContstructor {
  new (hour: number, minute: number);
}

//인터페이스를 implement할때, 클래스의 인스턴스만 검사하게 됨.
//그런데 생성자는 스태틱이므로 검사하지 않아 에러발생
class Clock implements ClockContstructor {
  currentTime: Date;

  constructor(h: number, m: number) {
  }
}

interface ClockConstructor2 {
  new(hour: number, minute: number): ClockInterface;
}

interface ClockInterface {
  tick(): void;
}

// ClockConstructor2타입인 전달받은 ctor가 올바른 생성자 시그니처를 가지고 있는지 검사함
function createClock(ctor: ClockConstructor2, hour: number, minute: number): ClockInterface {
  return new ctor(hour, minute);
}

class DigitalClock implements ClockInterface {
  constructor(h: number, m: number) {
  }

  tick() {
    console.log("beep beep");
  }
}

class AnalogClock implements ClockInterface {
  constructor(h: number, m: number) {
  }

  tick() {
    console.log("tick tock");
  }
}

const digital = createClock(DigitalClock, 12, 17);
const analog = createClock(AnalogClock, 7, 32);

const Clock2: ClockContstructor = class Clock implements ClockInterface {
  constructor(h: number, m: number) {
  }

  tick() {
    console.log("beep beep");
  }
}
