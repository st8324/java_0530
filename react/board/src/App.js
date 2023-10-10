import {BrowserRouter, Routes, Route} from 'react-router-dom'
import Home from './Home';
import Header from './Header';
import Insert from './Insert';
import {useState} from 'react'

function App() {
  let [list, setList] = useState([{
    num : 1,
    title : '공지사항',
    writer: 'admin'
  },{
    num : 2,
    title : '첫번째 게시글',
    writer: 'qwer'
  }]);
  const deleteBoard = (num)=>{
    let tmpList = list.filter(item=>item.num != num);
    setList(tmpList);
  }
  const addBoard = (board)=>{
    setList([board, ...list]);
  }
  return (
    <BrowserRouter>
      <Header/>
      <Routes>
        <Route path="/" exact element={<Home list={list} deleteBoard={deleteBoard} add={addBoard} />} />
        <Route path='/insert' element={<Insert/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
