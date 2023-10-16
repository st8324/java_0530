import {BrowserRouter, Routes, Route, Link, useLocation, useNavigate} from 'react-router-dom'
import {useState} from 'react'

function App() {
  let [list, setList] = useState([{
    id : 1,
    title : 'Movie1',
    genre: 'Drama',
    releaseDate : '2022-01-01'
  },{
    id :2,
    title : 'Movie2',
    genre: 'Action',
    releaseDate : '2022-01-02'
  }]);
  const deleteBoard = (id)=>{
    let tmpList = list.filter(item=>item.id != id);
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

function Header(){
	return(
		<header className='menu'>
			<ul className='menu-list'>
				<li className='menu-item'>
					<Link to="/" className='menu-link'>게시글 리스트</Link>
				</li>
				<li className='menu-item'>
					<Link to="/insert" className='menu-link'>게시글 등록</Link>
				</li>
			</ul>
		</header>
	)
}

function Home({list, deleteBoard, add}){
	const location = useLocation();
	let board = location.state;
	if(board != null){
		add(board);
		location.state = null;
	}
	return (
		<main>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Genre</th>
            <th>Release Date</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					{list.length == 0 ?
						<tr><th colSpan={4}><h1>등록된 영화가 없습니다.</h1></th></tr> :
						list.map(item=>{
							return(
								<tr key={item.id}>
									<td>{item.id}</td>
									<td>{item.title}</td>
									<td>{item.genre}</td>
                  <td>{item.releaseDate}</td>
									<td><button onClick={()=>{deleteBoard(item.id)}}>삭제</button></td>
								</tr>
							)
						})
					}
				</tbody>
			</table>
		</main>
	)
}

function Insert(){
	const navigate = useNavigate();
	const [id, setId] = useState('');
	const [title, setTitle] = useState('');
	const [genre, setGenre] = useState('');
  const [releaseDate, setReleaseDate] = useState('');

	const idChange = e => setId(e.target.value);
	const titleChange = e => setTitle(e.target.value);
	const genreChange = e => setGenre(e.target.value);
  const releaseDateChange = e => setReleaseDate(e.target.value);

	const insertBoard = ()=>{
		navigate('/',{
			state : {
				id : id,
				title : title,
				genre : genre,
        releaseDate : releaseDate
			}
		})
	}
	return (
		<div>
			<input type="number" placeholder='ID' onChange={idChange} value={id}/> 
			<br/>
			<input type="text" placeholder='Title' onChange={titleChange} value={title}/>
			<br/>
			<input type="text" placeholder='Genre' onChange={genreChange} value={genre}/>
			<br/>
      <input type="date" onChange={releaseDateChange} value={releaseDate}/>
			<br/>
			<button onClick={insertBoard}>등록</button>
		</div>
	)
}

export default App;
