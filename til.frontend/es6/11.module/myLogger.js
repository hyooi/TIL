// 객체 형태로 export
// default로 export하면 임포트할 때 {}없이 바로 사용 가능
export const getTime = () => {
  return Date.now();
}

export const getCurrentHour = () => {
  return (new Date()).getHours();
}

export class MyLogger {
  constructor(props) {
    this.lectures = ['java', 'ios'];
  }

  getLectures() {
    return this.lectures;
  }
}