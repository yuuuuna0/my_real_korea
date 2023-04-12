import * as View from "./view.js";
import * as Request from "./request.js";


//동행게시판 검색
$(document).on('click','#tripboard-search-btn',function(e){
	let keyword = $('#tripboard-search-keyword').val();
	let url = `tripboard-search/${keyword}`;
	console.log(keyword);
	let method = 'GET';
	let contentType = 'application/json;charset=UTF-8';
	let sendData = {};
	let async = true;
	
	Request.ajaxRequest(url, method, contentType, sendData,
						function(resultJson){
							if(resultJson.code == 1){
								View.render('#tripboard-search-list-template', resultJson, '#tripboard-list');
							}else {
								alert(resultJson.msg);
							}
						}, async);
	e.preventDefault();
});