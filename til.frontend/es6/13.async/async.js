function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

const process = async() => {
  console.log('hi1!');
  await sleep(1000); //promise가 끝날때까지 기다릴 수 있음
  console.log('hi2!');
}

process().then(() => console.log('process ended!'));

/**
 * promise.all: 여러개의 promse중 하나라도 실패하면 모두 실패로 간주
 */

const getDog = async () => {
  await sleep(1000);
  return '멍!';
}

const getRabbit = async () => {
  await sleep(1000);
  return '토끼!';
}

async function process2() {
  const [dog, rabbit] = await Promise.all([
      getDog(), getRabbit()
  ])
  console.log(dog)
  console.log(rabbit)
}
process2()

/**
 * promise.race: 여러개의 프로미스 중 가장 빨리 종료된 결과를 가져옴
 * - 가장 먼저 끝난 promise가 실패하면 실패로 간주
 */
