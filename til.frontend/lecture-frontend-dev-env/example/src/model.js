import axios from "axios"

// const data = [
//   {keyword: '이탈리아'},
//   {keyword: '세프의요리'},
//   {keyword: '제철'},
//   {keyword: '홈파티'},
// ]

const model = {
  async get() {
    // return data

    const result = await axios.get("/api/keywords")
    return result.data
  },
}

export default model