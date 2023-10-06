function PageBox({page, maxPage, pageDown, pageUp}){
	return(
		<div className="page-box">
			<a href="javascript:void(0);" className="page-btn" onClick={pageDown}>&lt;</a>
			<span className="page">{page} / {maxPage}</span>
			<a href="javascript:void(0);" className="page-btn" onClick={pageUp}>&gt;</a>
		</div>
	);
}

export default PageBox;