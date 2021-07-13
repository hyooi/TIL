const path = require("path") //path: 노드에서 제공하는 기본 모듈. 경로 계산 라이브러리

module.exports = {
    mode: "development",
    entry: {
        main: "./src/app.js",
    },
    output: {
        filename: "[name].js", //name: entrypoint의 값
        path: path.resolve("./dist"), //resolve: 절대경로 가져옴
    },
}
