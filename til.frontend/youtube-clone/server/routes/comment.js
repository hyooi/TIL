const express = require('express');
const router = express.Router();
const { Comment } = require("../models/comment")

router.post("/saveComment", (req, res) => {
  const comment = new Comment(req.body)
  comment.save((err, comment) => {
    if(err) return res.json({success: false, err})

    // writer의 상세정보를 가져오기위해 한번 더 find함
    Comment.find({'_id': comment._id})
    .populate('writer')
    .exec((err, result) => {
      if(err) return res.json({success: false, err})
      res.status(200).json({success: true, result})
    })
  })
})

router.post("/getComments", (req, res) => {
  Comment.find({"postId": req.body.videoId})
  .populate('writer')
  .exec((err, comment) => {
    if(err) return res.status(400).send(err)
    res.status(200).json({success:true, comment})
    })
})

module.exports = router;