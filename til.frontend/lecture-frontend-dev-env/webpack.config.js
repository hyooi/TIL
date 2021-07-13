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
  module: {
    rules: [
      {
        test: /\.css$/, // .css 확장자로 끝나는 모든 파일
        use: [
          "style-loader", // 개발 환경
          "css-loader",
        ], // 웹팩은 뒤에서부터 로더를 적용함.
      },
      {
        test: /\.(png|jpg|gif|svg)$/, // .png 확장자로 마치는 모든 파일
        use: {
          loader: 'url-loader', // url 로더를 설정한다
          options: {
            publicPath: './dist/', // file-loader와 동일
            name: '[name].[ext]?[hash]', // file-loader와 동일
            limit: 10000 // 10kb 미만 파일만 data url로 처리하고, 넘으면 file
            // loader로 처리
          }
        }
      }
    ]
  }
}