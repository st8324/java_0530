import PageBox from "./PageBox";
import { useState } from "react";

function Box({className, maxPage, Contents}){
	let [page, setPage] = useState(1);
	const pageUp = ()=>setPage((prev)=>prev == maxPage ? 1 : prev+1);
	const pageDown = ()=>setPage((prev)=>prev == 1 ? maxPage : prev-1);
	return(
		<div className={className}>
			<PageBox page={page} maxPage={maxPage} pageDown={pageDown} pageUp={pageUp}/>
			<Contents/>
			<PageBox page={page} maxPage={maxPage} pageDown={pageDown} pageUp={pageUp}/>
		</div>
	);
}

export default Box;