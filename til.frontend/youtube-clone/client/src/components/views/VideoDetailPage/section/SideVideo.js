import React, {useEffect, useState} from "react";
import axios from "axios";

export default function SideVideo () {
  const [sideVideos, setSideVideos] = useState([])

  useEffect(() => {
    axios.get('/api/video/getVideos')
    .then(response => {
      if(response.data.success) {
        setSideVideos(response.data.videos)
      } else {
        alert('비디오 가져오기 실패했습니다.')
      }
    })
  }, [])

  const renderSideVideo = sideVideos.map((video, index) => {
    const minutes = Math.floor(video.duration / 60);
    const seconds = Math.floor((video.duration - minutes * 60));

    return <div key={index} style={{display: 'flex', marginBottom: "1rem", padding:"0 2rem"}}>
      <div style={{ width:'40%', marginRight: '1rem'}}>
        <a href>
          <img style={{width:'100%', height: '100%'}} src={`http://localhost:5000/${video.thumbnail}`} alt  />
        </a>
      </div>

      <div style={{ width: '50%' }}>
        <a href={`/video/${video._id}`} style={{color: 'gray'}}>
          <span style={{fontSize: '1rem', color:'black'}}>{video.title}</span><br/>
          <span>{video.writer.name}</span><br/>
          <span>{video.views} views</span><br/>
          <span>{minutes} : {seconds}</span>
        </a>
      </div>
    </div>
      }
  )
  return (
      <React.Fragment>
        <div style={{marginTop: '3rem'}}/>
        {renderSideVideo}
      </React.Fragment>
  )
}