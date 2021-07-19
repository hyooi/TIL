const express = require('express')
const app = express()
const port = 5000 //백엔드 서버의 포트!

const mongoose = require('mongoose')
mongoose.connect('mongodb+srv://testdb:test@hk.ypq3h.mongodb.net/myFirstDatabase?retryWrites=true&w=majority', {
  useNewUrlParser: true, useUnifiedTopology: true, useCreateIndex: true, useFindAndModify: false
}).then(() => console.log("Mongo db connected..."))
.catch(err => console.log(err));

app.get('/', (req, res) => {
  res.send('Hello World!')
})

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})