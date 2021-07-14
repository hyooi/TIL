module.exports = {
  parser: "babel-eslint",
  plugins: [
    "prettier"
  ],
  rules: {
    // "no-unexpected-multiline": "error",
    // "no-extra-semi": "error",
    "eslint:recommended": "error", // 미리 설정된 규칙 세트을 사용한다
    "prettier/prettier": "error"
  },
  extends: [
    "eslint:recommended",
    "plugin:prettier/recommended",
    "eslint-config-prettier"
  ]
}