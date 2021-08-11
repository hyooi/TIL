const Hello = ( {color, name, isSpecial} ) => {
  return (
      // JSX에서 null, false, undefined를 랜더링하면 아무것도 나타나지 않음
      <div style={{ color }}>
        {/*{isSpecial? <b>*</b> : null}*/}
        {isSpecial && <b>*</b>}
        안녕하세요 {name}
      </div>
  )
}

Hello.defaultProps = {
  name: '이름없음'
}

export default Hello;
