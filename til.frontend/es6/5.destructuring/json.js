const news = [
  {
    "title": "sbs",
    "imgurl": "http://sbs.com",
    "newslist": [
        "sbs뉴스1",
        "sbs뉴스2",
        "sbs뉴스3",
        "sbs뉴스4",
    ]
  },
  {
    "title": "mbc",
    "imgurl": "http://mbc.com",
    "newslist": [
      "mbc뉴스1",
      "mbc뉴스2",
      "mbc뉴스3",
      "mbc뉴스4",
    ]
  }
];

// let [,mbc] = news;
// console.log(mbc);
//
// let {title, imgurl} = mbc;
// console.log(title, imgurl);

let [, {title, imgurl}] = news;
console.log(title, imgurl);

function getNewsList([{newslist}]) {
  console.log(newslist);
}

getNewsList(news);