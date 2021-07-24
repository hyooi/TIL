import {Tooltip} from 'antd';
import {LikeOutlined, DislikeOutlined} from '@ant-design/icons';
import {useEffect, useState} from "react";
import axios from "axios";

export default function LikeDislike(props) {
  const [Likes, setLikes] = useState(0)
  const [LikesAction, setLikeAction] = useState(null)
  const [DisLikes, setDisLikes] = useState(0)
  const [DisLikesAction, setDisLikeAction] = useState(null)

  let variable = {}
  if (props.video) {
    variable = {videoId: props.videoId, userId: props.userId,}
  } else {
    variable = {commentId: props.commentId, userId: props.userId}
  }

  useEffect(() => {
    axios.post('/api/like/getLikes', variable)
    .then(response => {
      if (response.data.success) {
        setLikes(response.data.likes.length)
        response.data.likes.map(like => {
          if(like.userId === props.userId) {
            setLikeAction('liked')
          }
        })
      } else {
        alert('likes의 정보를 가져오지 못했습니다.')
      }
    })

    axios.post('/api/like/getDisLikes', variable)
    .then(response => {
      if (response.data.success) {
        setDisLikes(response.data.disLikes.length)
        response.data.disLikes.map(disLike => {
          if(disLike.userId === props.userId) {
            setDisLikeAction('disliked')
          }
        })
      } else {
        alert('dislikes의 정보를 가져오지 못했습니다.')
      }
    })
  }, [])

  const onLike = () => {
    if(LikesAction === null) {
      axios.post('/api/like/upLike', variable)
      .then((response) => {
        if(response.data.success) {
          setLikes(Likes+1)
          setLikeAction('liked')

          if(DisLikesAction !== null) {
            setDisLikeAction(null)
            setDisLikes(DisLikes-1)
          }
        } else {
          alert('like에 실패했습니다.')
        }
      })
    } else {
      axios.post('/api/like/unLike', variable)
      .then((response) => {
        if(response.data.success) {
          setLikes(Likes-1)
          setLikeAction(null)
        } else {
          alert('like에 실패했습니다.')
        }
      })
    }
  }

  const onDisLike = () => {
    if(DisLikesAction !== null) {
      axios.post('/api/like/unDislike', variable)
      .then(response => {
        if (response.data.success) {
          setDisLikes(DisLikes -1)
          setDisLikeAction(null)
        } else {
          alert('dislike을 삭제하지 못했습니다.')
        }
      })
    } else {
      axios.post('/api/like/upDislike', variable)
      .then(response => {
        if (response.data.success) {
          setDisLikes(DisLikes+1)
          setDisLikeAction('disliked')

          if(LikesAction !== null) {
            setLikeAction(null)
            setLikes(Likes-1)
          }
        } else {
          alert('dislike을 삭제하지 못했습니다.')
        }
      })
    }
  }

  return (
      <div>
        <span key="comment-basic-like">
          <Tooltip title="Like">
            {LikesAction === 'liked'?
                <LikeOutlined style={{color: '#08c'}} onClick={onLike}/> :
                <LikeOutlined style={{color: '#8e8e8e'}} onClick={onLike}/>
            }
          </Tooltip>
        </span>

        <span style={{paddingLeft: '8px', cursor: 'auto'}}> {Likes} </span>
        &nbsp;&nbsp;
        <span key="comment-basic-dislike">
          <Tooltip title="DisLike">
            {DisLikesAction === 'disliked'?
                <DislikeOutlined style={{color: '#cc0000'}} onClick={onDisLike}/> :
                <DislikeOutlined style={{color: '#8e8e8e'}} onClick={onDisLike}/>
            }
          </Tooltip>
        </span>
        <span style={{paddingLeft: '8px', cursor: 'auto'}}> {DisLikes} </span>
      </div>
  )
}