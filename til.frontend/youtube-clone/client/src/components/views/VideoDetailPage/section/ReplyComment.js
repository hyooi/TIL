import SingleComment from "./SingleComment";
import {useEffect, useState} from "react";

export default function ReplyComment(props) {
  const [ChildCommentNumber, setChildCommentNumber] = useState(0)
  const [OpenReplyComments, setOpenReplyComments] = useState(false)

  useEffect(() => {
    let commentNumber = 0
    props.commentLists.map((comment) => {
      if(comment.responseTo === props.parentCommentId) {
        commentNumber++
      }
    })

    setChildCommentNumber(commentNumber)
  }, [props.commentLists]) //commentList가 변경될때마다 useEffect를 재실행

  const renderReplyComment = (parentCommentId) =>
    props.commentLists.map((comment, index) => (
        <>
          {comment.responseTo === parentCommentId &&
          <div style={{width: '80%', marginLeft: '40px'}}>
            <SingleComment refreshFunction={props.refreshFunction}
                           comment={comment} postId={props.postId}/>
            <ReplyComment refreshFunction={props.refreshFunction} parentCommentId={comment._id} commentLists={props.commentLists} postId={props.postId} />
          </div>
          }
        </>
    ))

  const onHandleChange = () => {
    setOpenReplyComments(!OpenReplyComments)
  }

  return (
      <div>
        {ChildCommentNumber > 0 &&
          <p style={{fontSize: '14px', margin: 0, color: 'grey'}} onClick={onHandleChange}>
          View {ChildCommentNumber} more comment(s)
          </p>
        }

        {OpenReplyComments &&
          renderReplyComment(props.parentCommentId)
        }
      </div>
  )
}