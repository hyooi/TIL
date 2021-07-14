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
  console.log("핫모듈 켜짐")

  module.hot.accept("./view", () => {
    console.log("view 모듈 변경됨")
  })
}