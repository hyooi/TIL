const data = [
  {
    name: 'coffe-bean',
    order: true,
    items: ['americano', 'milk', 'green-tea']
  },
  {
    name: 'starbucks',
    order: false,
  }
]

// tagged template literals
function fn(tags, name, items) {
  if(typeof items === 'undefined') {
    items = "<span style='color:red'>주문가능한 상품이 없습니다.</span>"
  }

  return (tags[0] + name + tags[1] + items + tags[2]);
}
data.forEach(v => {
  let template = fn`
    <div>welcome ${v.name}!!</div>
    <h2>주문가능항목</h2>
    <div>${v.items}</div>
  `;
  console.log(template);
})
