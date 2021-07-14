const path = require("path") //path: 노드에서 제공하는 기본 모듈. 경로 계산 라이브러리
const webpack = require('webpack');
const banner = require("./banner.js")
const HtmlWebpackPlugin = require('html-webpack-plugin');
const {CleanWebpackPlugin} = require("clean-webpack-plugin")
const MiniCssExtractPlugin = require("mini-css-extract-plugin")

module.exports = {
  mode: "production", //development
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
          process.env.NODE_ENV === "production"
              ? MiniCssExtractPlugin.loader // 프로덕션 환경
              : "style-loader", // 개발 환경
          "css-loader",
        ], // 웹팩은 뒤에서부터 로더를 적용함.
      },
      {
        test: /\.png$/, // .png 확장자로 마치는 모든 파일
        use: {
          loader: 'url-loader', // url 로더를 설정한다
          options: {
            publicPath: './dist/', // file-loader와 동일
            name: '[name].[ext]?[hash]', // file-loader와 동일
            limit: 5000 // 5kb 미만 파일만 data url로 처리하고, 넘으면 file
            // loader로 처리
          }
        }
      },
      {
        test: /\.js$/,
        exclude: /node_modules/,
        loader: "babel-loader", // 바벨 로더를 추가한다
      },
    ],
    // .js로 끝나는 모든 파일에 myloader.js를 적용한다
    // rules: [{
    //     test: /\.js$/,
    //     use: [path.resolve('./myloader.js')]
    // }],
  },
  plugins: [
    new webpack.BannerPlugin(banner),
    new webpack.DefinePlugin({
      TWO: '1+1',
      TWO_STR: JSON.stringify('1+1'),
    }),
    new HtmlWebpackPlugin({
      template: './src/index.html', // 템플릿 경로를 지정
      templateParameters: { // 템플릿에 주입할 파라매터 변수 지정
        env: process.env.NODE_ENV === 'development' ? '(개발용)' : '',
        minify: process.env.NODE_ENV === 'production' ? {
          collapseWhitespace: true, // 빈칸 제거
          removeComments: true, // 주석 제거
        } : false,
        hash: true,
      },
    }),
    new CleanWebpackPlugin(),
    ...(process.env.NODE_ENV === "production"
        ? [new MiniCssExtractPlugin({filename: `[name].css`})]
        : []),//production인 경우 css를 별도로 분리하여 속도 개선
  ],
}
