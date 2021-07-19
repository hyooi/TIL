const mongoose = require('mongoose');

const userSchema = mongoose.Schema({
  name: {
    type: String,
    maxLength: 50
  },
  email: {
    type: String,
    trim: true, //공백을 자동으로 삭제함
    unique: 1
  },
  password: {
    type: String,
    minLength: 5
  },
  lastname: {
    type: String,
    maxLength: 50
  },
  role: {
    type: Number,
    default: 0 //role이 없으면 기본 0
  },
  image: String,
  token: {
    type: String
  },
  tokenExpiration: {
    type: Number
  }
})

const User = mongoose.model('User', userSchema)
module.exports = { User }