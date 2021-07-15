const path = require("path") //path: 노드에서 제공하는 기본 모듈. 경로 계산 라이브러리
const webpack = require('webpack');
const banner = require("./banner.js")

const HtmlWebpackPlugin = require('html-webpack-plugin');
const {CleanWebpackPlugin} = require("clean-webpack-plugin")

const apiMocker = require("connect-api-mocker")

const MiniCssExtractPlugin = require("mini-css-extract-plugin")
const OptimizeCSSAssetsPlugin = require("optimize-css-assets-webpack-plugin")
const TerserPlugin = require("terser-webpack-plugin")
const CopyPlugin = require("copy-webpack-plugin")

module.exports = {
  mode: 'development',
  entry: {
    main: "./src/app.js",
  },
  output: {
    filename: "[name].js", //name: entrypoint의 값
    path: path.resolve("./dist"), //resolve: 절대경로 가져옴
  },
  externals: {
    axios: "axios",
  },
  optimization: {
    minimizer: process.env.NODE_ENV === "production" ? [
        new OptimizeCSSAssetsPlugin(),
        new TerserPlugin({
          terserOptions: {
            compress: {
              drop_console: true, // 콘솔 로그를 제거한다
            },
          },
        }),
    ] : [],
  },
  module: {
    rules: [
      {
        test: /\.css$/, // .css 확장자로 끝나는 모든 파일
        use: [
          process.env.NODE_ENV === "production" ? MiniCssExtractPlugin.loader // 프로덕션 환경
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
    new CopyPlugin({
      patterns: [
        { from: "./node_modules/axios/dist/axios.min.js", to: "./axios.min.js"},
      ]
    }),
  ],
  devServer: {
    contentBase: path.join(__dirname, "dist"), //정적파일을 제공하는 경로. default: output
    publicPath: "/", //브라우저를 통해 접근하는 경로. 기본값 /
    host: "localhost", //개발환경에서 도메인을 서버와 동일하게 사용해야 하는경우 사용
    overlay: true, //빌드 시 에러,경고를 브라우저에 표시
    port: 8081, //기본값 8080
    stats: "errors-only", //메시지 레벨을 정할 수 있음
    hot: true,

    //html5의 history api를 사용. 404가 발생하면 index.html로 리다이렉트
    historyApiFallback: true,
    before: (app, server, compiler) => {
      app.use(apiMocker("/api", "mocks/api"))
      // app.get("/api/keywords", (req, res) => {
      //   res.json([
      //     {keyword: "이탈리아"},
      //     {keyword: "세프의요리"},
      //     {keyword: "제철"},
      //     {keyword: "홈파티"},
      //   ])
      // })
    },
    proxy: {
      // api로 시작하는 http요청을 프록시해 localhost:8081로 요청
      "/api": "http://localhost:8081",
    },
  },
}
