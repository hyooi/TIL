const express = require('express')
const app = express()
const port = 5000 //백엔드 서버의 포트!

const bodyParser = require('body-parser');
const { User } = require('./model/User');

app.use(bodyParser.urlencoded({extended: true})); // application/x-www-form-urlencoded
app.use(bodyParser.json()); //application/json

const mongoose = require('mongoose')
mongoose.connect('mongodb+srv://testdb:test@hk.ypq3h.mongodb.net/myFirstDatabase?retryWrites=true&w=majority', {
  useNewUrlParser: true, useUnifiedTopology: true, useCreateIndex: true, useFindAndModify: false
}).then(() => console.log("Mongo db connected..."))
.catch(err => console.log(err));


app.get('/', (req, res) => {
  res.send('Hello World!')
})

app.post('/register', (req, res) => {
  const user = new User(req.body)
  user.save((err, userInfo) => {
    console.log("result: ", err)
    if(err) return res.json({ success: false, err })
    return res.status(200).json({
      success: true
    })
  })
});

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
});