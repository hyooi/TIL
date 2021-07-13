const path = require("path")
const HtmlWebpackPlugin = require('html-webpack-plugin');
const {CleanWebpackPlugin} = require("clean-webpack-plugin")
const MiniCssExtractPlugin = require("mini-css-extract-plugin")
const webpack = require('webpack');

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
        ],
      },
      {
        test: /\.(png|jpg|gif|svg)$/, // .png 확장자로 마치는 모든 파일
        use: {
          loader: 'url-loader', // url 로더를 설정한다
          options: {
            name: '[name].[ext]?[hash]', // file-loader와 동일
            limit: 10000 // 10kb 미만 파일만 data url로 처리하고, 넘으면 file
            // loader로 처리
          }
        }
      }
    ]
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './src/index.html', // 템플릿 경로를 지정
      templateParameters: { // 템플릿에 주입할 파라매터 변수 지정
        env: process.env.NODE_ENV === 'development' ? '(개발용)' : '',
        minify: process.env.NODE_ENV === 'production' ? {
          collapseWhitespace: true, // 빈칸 제거
          removeComments: false, // 주석 제거
        } : false,
        hash: true,
      },
    }),
    new CleanWebpackPlugin(),
    new webpack.BannerPlugin({
      banner: () => `빌드 날짜: ${new Date().toLocaleString()}`
    }),
    new CleanWebpackPlugin(),
    ...(process.env.NODE_ENV === "production"
        ? [new MiniCssExtractPlugin({filename: `[name].css`})]
        : []),//production인 경우 css를 별도로 분리하여 속도 개선
  ]
}