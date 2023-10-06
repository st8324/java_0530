import { useState } from "react";
import ContentsA from "./ContentsA";
import ContentsB from "./ContentsB";
import Box from "./Box";

function Body(){

	return (
		<div className="body">
			<Box className={"left"}  maxPage={13} Contents={ContentsA}/>
			<Box className={"right"} maxPage={6} Contents={ContentsB}/>
		</div>
	)
}


/*
function Left(){
	const maxPage = 13;
	let [page, setPage] = useState(1);
	const pageUp = ()=>setPage((prev)=>prev == maxPage ? 1 : prev+1);
	const pageDown = ()=>setPage((prev)=>prev == 1 ? maxPage : prev-1);
	return(
		<div className="left">
			<PageBox page={page} maxPage={maxPage} pageDown={pageDown} pageUp={pageUp}/>
			<div className="contents"></div>
			<PageBox page={page} maxPage={maxPage} pageDown={pageDown} pageUp={pageUp}/>
		</div>
	);
}
function Right(){
	const maxPage = 6;
	let [page, setPage] = useState(1);
	const pageUp = ()=>setPage((prev)=>prev == maxPage ? 1 : prev+1);
	const pageDown = ()=>setPage((prev)=>prev == 1 ? maxPage : prev-1);
	return(
		<div className="right">
			<PageBox page={page} maxPage={maxPage} pageDown={pageDown} pageUp={pageUp}/>
			<div className="contents"></div>
			<PageBox page={page} maxPage={maxPage} pageDown={pageDown} pageUp={pageUp}/>
		</div>
	);
}
*/

export default Body;