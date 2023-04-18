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

//동행게시판 정렬(최신순, 조회수높은순)
$(document).on('change', '#sort-by', function(e) {
	let selectedValue = $(this).val();
	console.log(selectedValue);
	
	if(selectedValue === "tripboard-date-desc") {
		let url = 'tripboard-date-desc';
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
	}
	
	if(selectedValue === "tripboard-readcount") {
		let url = 'tripboard-readcount';
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
	}
});

//동행게시판 필터(사이드바 전체보기, 지역별 보기)
$(document).on('click', '#all-city-list', function(e) {
	let cityNo=$(this).attr('name');
	console.log(cityNo);
		let url;
		let method = 'GET';
		let contentType = 'application/json;charset=UTF-8';
		let sendData;
		if(cityNo==0){
			url= 'tripboard-all-list';
			sendData={};
		} else{
			url= 'tripboard-city-list';
			sendData={
				cityNo:cityNo
			};
		}
		let async = true;
		
		Request.ajaxRequest(url, method, contentType, 
							sendData,
							function(resultJson){
								if(resultJson.code == 1){
									View.render('#tripboard-search-list-template', resultJson, '#tripboard-list');
								}else {
									alert(resultJson.msg);
								}
							}, async);
		e.preventDefault();
});


