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
    module: {
        rules: [
            {
                test: /\.css$/, // .css 확장자로 끝나는 모든 파일
                use: ["style-loader", "css-loader"], // 웹팩은 뒤에서부터 로더를 적용함.
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
            }
        ],
        // .js로 끝나는 모든 파일에 myloader.js를 적용한다
        // rules: [{
        //     test: /\.js$/,
        //     use: [path.resolve('./myloader.js')]
        // }],
    }
}
