import React, {useEffect, useState} from 'react'
import {Card, Row, Col, Typography, Avatar} from "antd";
import axios from "axios";
import moment from "moment";

const {Title} = Typography
const {Meta} = Card

function LandingPage() {
    const [Video, setVideo] = useState([])

    //dom이 로드되자마자 할일 정의. componentDidMount와 같은 일을 함
    useEffect(() => {
        axios.get('/api/video/getVideos')
        .then(response => {
            if(response.data.success) {
                setVideo(response.data.videos)
            } else {
                alert('비디오 가져오기 실패했습니다.')
            }
        })
    }, []) //deps가 비어있어야 한번만 실행함.

    const renderCards = Video.map((video, index) => {
        const minutes = Math.floor(video.duration / 60);
        const seconds = Math.floor((video.duration - minutes * 60));

        return <Col lg={6} md={8} xs={24}>
            <a href={`/video/${video._id}`}>
                <div style={{ position: 'relative' }}>
                    <img style={{ width: '100%' }} src={`http://localhost:5000/${video.thumbnail}`} alt=""/>
                    <div className="duration">
                        <span>{minutes} : {seconds}</span>
                    </div>
                </div>
            </a>
            <br/>
            <Meta avatar={
                <Avatar src={video.writer.image} />
            } title={video.title} description=""/>
            <span>{video.writer.name}</span><br/>
            <span style={{ marginLeft: '3rem' }}>{video.views} views</span>
            - <span>{moment(video.createdAt).format("MMM Do YY")}</span>
        </Col>
    })

    return (
      <div style={{ width: '85%', margin: '3rem auto'}}>
        <Title level={2}>Home</Title>
        <hr/>
        <Row gutter={[32, 16]}>
            {renderCards}
        </Row>
      </div>
    )
}

export default LandingPage
