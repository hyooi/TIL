//성공 시 resolve, 실패 시 reject호출
const myPromise = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve(1);
    // reject(new Error());
  }, 1000);
})

myPromise.then(n => {
  console.log(n);
}).catch(error => {
  console.error(error);
});

const increaseAndPrint = (n) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const value = n+1;
      if(value === 5) {
        const error = new Error();
        error.name = 'valuesIsFiveError';
        reject(error);

        return;
      }
      console.log(value);
      resolve(value);
    }, 1000);
  })
}

//increaseAndPrint 연달아 사용
increaseAndPrint(0)
  .then(increaseAndPrint)
  .then(increaseAndPrint)
  .then(increaseAndPrint)
  .catch(e => {
    console.error(e);
  })
