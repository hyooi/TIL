import model from "./model"
import view from "./view"

const controller = {
  async init(el) {
    this.el = el
    view.render(await model.get(), this.el)
  },
}

export default controller

if (module.hot) {
  module.hot.accept("./view", async () => {
    view.render(await model.get(), controller.el) // 변경된 모듈로 교체
  })
}