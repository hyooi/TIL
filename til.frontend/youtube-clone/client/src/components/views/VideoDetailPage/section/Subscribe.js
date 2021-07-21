import {useEffect, useState} from "react";
import axios from "axios";

export default function Subscribe(props) {
  const [SubscribeNumber, setSubscribeNumber] = useState();
  const [Subscribed, setSubscribed] = useState(false);

  useEffect(() => {
    let variable = {userTo: props.userTo}

    axios.post('/api/subscribe/subscribeNumber', variable)
    .then(response => {
      if(response.data.success) {
        setSubscribeNumber(response.data.subscribeNumber)
      } else {
        alert('구독자 수 정보를 받아오지 못했습니다.')
      }
    })

    let subscribedVariable = {userTo: props.userTo, userFrom: localStorage.getItem('userId')}
    axios.post('/api/subscribe/subscribed', subscribedVariable)
    .then(response => {
      if(response.data.success) {
        setSubscribed(response.data.subscribed)
      } else {
        alert('정보를 받아오지 못했습니다.')
      }
    })
  }, [])

  const onSubscribe = () => {
    let variable = {
      userTo: props.userTo,
      userFrom: props.userFrom,
    }
    if(Subscribed) {
      axios.post('/api/subscribe/unsubscribe', variable)
      .then(response => {
        if(response.data.success) {
          setSubscribeNumber(SubscribeNumber - 1)
          setSubscribed(!Subscribed)
        } else {
          alert('구독 취소하는데 실패했습니다.')
        }
      })
    } else {
      axios.post('/api/subscribe/subscribe', variable)
      .then(response => {
        if(response.data.success) {
          setSubscribeNumber(SubscribeNumber + 1)
          setSubscribed(!Subscribed)
        } else {
          alert('구독하는데 실패했습니다.')
        }
      })
    }
  }

  return (
      <div>
        <button style={{backgroundColor: `${Subscribed? '#AAAAAA' : '#CC0000'}`, borderRadius: '4px',
        color: 'white', padding: '10px 16px',
        fontWeight: '500', fontSize: '1rem', textTransform: 'uppercase'}}
        onClick={onSubscribe}>
          {SubscribeNumber} {Subscribed? 'Subscribed' : 'Subscribe'}
        </button>
      </div>
  )
}