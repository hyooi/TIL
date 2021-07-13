class MyPlugin {
  apply(compiler) {
    compiler.hooks.done.tap("My Plugin", () => {
      console.log("MyPlugin: done")
    })

    compiler.hooks.emit.tap("emit", (compilation) => {
      const source = compilation.assets["main.js"].source() //최종 소스코드를 가져옴
      compilation.assets['main.js'].source = () => {
        const banner = [
          '/**',
          ' * 이것은 BannerPlugin이 처리한 결과입니다.',
          ' * Build Date: 2019-10-10',
          ' */',
          ''
        ].join('\n');

        return banner + '\n' + source;
      }

      console.log(compilation.assets["main.js"].source())
    })
  }
}

module.exports = MyPlugin