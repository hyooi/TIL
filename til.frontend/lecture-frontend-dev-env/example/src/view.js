const view = {
  render(data, el) {
    el.innerHTML = '<ol>' + data.map(item => {
      return `<li>123${item.keyword}</li>`
    }).join('') + '</ol>'
  }
}

export default view;