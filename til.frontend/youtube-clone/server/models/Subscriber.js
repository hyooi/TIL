const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const subscriberSchema = mongoose.Schema({
  userTo: {
    type: Schema.Types.ObjectId,
    ref:'User'
  },
  userForm: {
    type: Schema.Types.ObjectId,
    ref: 'User'
  }
}, {timestamp: true})
const Subscriber = mongoose.model('Subscriber', subscriberSchema);

module.exports = { Subscriber }