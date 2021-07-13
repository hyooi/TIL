const path = require("path")

module.exports = {
  mode: "development", //development
  entry: {
    main: "./src/app.js",
  },
  output: {
    filename: "[name].js", //name: entrypoint의 값
    path: path.resolve("./dist"), //resolve: 절대경로 가져옴
  },
}