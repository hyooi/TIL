interface ClockInterface {
  currentTime: Date;
  setTime(d: Date): void;
}

class Clock implements ClockInterface {
  currentTime: Date = new Date();
  constructor(h: number, m:number) {
  }

  setTime(d: Date): void {
    this.currentTime = d;
  }
}