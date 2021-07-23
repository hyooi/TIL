import {useState} from "react";
import axios from "axios";

import { useSelector} from "react-redux";

export default function Comment(props) {
  const user = useSelector(state => state.user)
  const [commentValue, setCommentValue] = useState('')

  const handleClick = (event) => {
    setCommentValue(event.currentTarget.value)
  }

  const onSubmit = (event) => {
    event.preventDefault()

    const variables = {
      content: commentValue,
      writer: user.userData._id,
      postId: props.videoId
    }

    axios.post('/api/comment/saveComment', variables)
    .then(response => {
      if(response.data.success) {
        console.log(response.data)
      } else {
        alert('코멘트를 저장하지 못했습니다.')
      }
    })
  }

  return (
    <div>
      <br/>
      <p>Replies</p>
      <hr/>

      <form style={{ display: 'flex'}} onSubmit={onSubmit}>
        <textarea style={{ width:'100%', borderRadius:'5px'}}
          onChange={handleClick} value placeholder='코멘트를 작성해주세요.' />
        <br/>
        <button style={{ width: '20%', height: '52px'}}>Submit</button>
      </form>
    </div>
  )
}