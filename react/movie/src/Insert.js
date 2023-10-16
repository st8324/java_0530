import {useState} from 'react';
import {useNavigate} from 'react-router-dom'

function Insert(){
	const navigate = useNavigate();
	const [num, setNum] = useState(1);
	const [title, setTitle] = useState('');
	const [writer, setWriter] = useState('');

	const numChange = e => setNum(e.target.value);
	const titleChange = e => setTitle(e.target.value);
	const writerChange = e => setWriter(e.target.value);

	const insertBoard = ()=>{
		navigate('/',{
			state : {
				num : num,
				title : title,
				writer : writer
			}
		})
	}
	return (
		<div>
			<input type="number" placeholder='게시글 번호' onChange={numChange} value={num}/> 
			<br/>
			<input type="text" placeholder='게시글 제목' onChange={titleChange} value={title}/>
			<br/>
			<input type="text" placeholder='작성자' onChange={writerChange} value={writer}/>
			<br/>
			<button onClick={insertBoard}>등록</button>
		</div>
	)
}

export default Insert;

