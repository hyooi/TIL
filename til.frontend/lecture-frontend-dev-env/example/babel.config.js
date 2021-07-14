module.exports = {
    presets: [
        // "./my-babel-preset.js",
        ["@babel/preset-env", {
            targets: {
                chrome: '79', // 크롬 79까지 지원하는 코드를 만든다
                ie: '11'
            },
            useBuiltIns: "usage", // 폴리필 사용 방식 지정. usage나 entry를 지정하면 core-js를 모듈로 가져옴
            corejs: { // 폴리필 버전 지정
                version: 2,
            },
        }]
    ],
}
