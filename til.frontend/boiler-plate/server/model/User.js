const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const saltRounds = 10
const jwt = require('jsonwebtoken')

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

userSchema.pre('save', function (next) {
  const user = this;

  if(user.isModified('password')) {
    //패스워드 암호화
    bcrypt.genSalt(saltRounds, function (err, salt) {
      if(err) {
        return next(err)
      }

      bcrypt.hash(user.password, salt,function (err, hash) {
        if(err) return next(err)
        user.password = hash

        next()
      })
    })

  } else {
    next();
  }
})

userSchema.methods.comparePassword = function (plainPassword, callback) {
  bcrypt.compare(plainPassword, this.password, function (err, isMatch) {
    if(err) return callback(err);
    callback(null, isMatch)
  })
}

userSchema.methods.generateToken = function (callback) {
  const user = this;
  user.token = jwt.sign(user._id.toHexString(), 'secretToken')
  user.save(function (err, user) {
    if(err) return callback(err)
    callback(null, user)
  })
}

userSchema.methods.findByToken = function (token, callback) {
  const user = this;
  jwt.verify(token, 'secretToken', function (err, decoded) {
    user.findOne({"_id": decoded, "token": token}, function (err, user) {
      if(err) return callback(err);
      callback(null, user);
    })
  })
}

const User = mongoose.model('User', userSchema)
module.exports = { User }