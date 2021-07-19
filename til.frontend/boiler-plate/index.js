const express = require('express')
const app = express()
const port = 5000 //백엔드 서버의 포트!

app.get('/', (req, res) => {
  res.send('Hello World!')
})

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})