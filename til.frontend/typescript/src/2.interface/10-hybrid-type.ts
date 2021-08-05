/**
 * 하이브리드 타입
 * - 함수와 객체 역할을 모두 수행
 */
interface Counter {
  (start: number): string;
  interval: number;
  reset(): void;
}

function getCounter(): Counter {
  let counter = (function (start: number) {}) as Counter;
  counter.interval = 123;
  counter.reset = function () {};

  return counter;
}

let c = getCounter();
c(10);
c.reset();
c.interval = 5.0;
