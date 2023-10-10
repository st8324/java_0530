import React from 'react'
import {Link} from 'react-router-dom'

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

export default Header;