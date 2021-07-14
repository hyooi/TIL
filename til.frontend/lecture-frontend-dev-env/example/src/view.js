export default class View {
  static _messages = {
    NO_KEYWORDS: "추천 검색어가 없습니다"
  };

  static render(data, el) {
    el.innerHTML = data.length ? View.getKeywordsHtml(data)
        : this._messages.NO_KEYWORDS;
    return this;
  }

  static getKeywordsHtml(data) {
    return (
        data.reduce((html, item, index) => {
          html += `<li data-keyword="${
              item.keyword
          }"><span class="number">${index + 1}. </span>${item.keyword}</li>`;
          return html;
        }, '<ul class="KeywordView">') + "</ul>"
    );
  }
}