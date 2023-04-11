import * as View from "./view.js";
import * as Request from "./request.js";
 
/*
 이벤트 등록 하는 공용 클래스
 #notice-search-btn
 #sort-by
 #type-tour
 #type-ticket
 */
 
// on => 동적으로 이벤트 추가 가능 -> 상위 노드에 처리해줘야함 (document)

/******** 공지사항 검색결과 리스트 notice-search-list **********/ 
$(document).on('click','#notice-search-btn',function(e){
	// ajax로 리스트 부분만 검색된 리스트로 변경
	let keyword = $('#notice-search-keyword').val();
	let url = `notice-search/${keyword}`;
	let method = 'GET';
	let contentType = 'application/json;charset=UTF-8';
	let sendData = {};
	let async = true;
	
	// 키워드 결과, 현재 페이지 숫자 표시
	let curPage = $('#cur-page');
	let totRecordCount = $('#tot-record-count');
	
	// JSON.stringify() => 객체를 string 으로, JSON.parse() => string 을 객체로 만듬
	Request.ajaxRequest(url, method, contentType, 
						sendData,
						function(resultJson){
							//페이지 정보 변경
							curPage.text(resultJson.data.pageMaker.curPage);
							totRecordCount.text(resultJson.data.pageMaker.totCount);
							//code 1 일때 render, 아닐 때 msg 띄움
							if(resultJson.code == 1){
								View.render("#notice-search-list-template", resultJson, '#notice-list');
							} else {
								alert(resultJson.msg);
							};
						}, async);
	
	e.preventDefault();
});

/******** 공지사항 정렬 : 최신순, 오래된순, 조회수 높은 순 **********/ 
$(document).on('change','#sort-by',function(e){
	// ajax로 리스트 부분만 검색된 리스트로 변경
	let selectedValue = $(this).val();
	console.log(selectedValue);
	if(selectedValue === "notice-date-desc"){
		// 최신순
		let url = 'notice-date-desc';
		let method = 'GET';
		let contentType = 'application/json;charset=UTF-8';
		let sendData = {};
		let async = true;
	
		Request.ajaxRequest(url, method, contentType, 
							sendData,
							function(resultJson){
								//code 1 일때 render, 아닐 때 msg 띄움
								if(resultJson.code == 1){
									View.render("#notice-search-list-template", resultJson, '#notice-list');
								} else {
									alert(resultJson.msg);
								};
							}, async);
		e.preventDefault();
		}
		
	if(selectedValue === "notice-date-asc"){
		// 오래된순
		let url = 'notice-date-asc';
		let method = 'GET';
		let contentType = 'application/json;charset=UTF-8';
		let sendData = {};
		let async = true;
	
		Request.ajaxRequest(url, method, contentType, 
							sendData,
							function(resultJson){
								//code 1 일때 render, 아닐 때 msg 띄움
								if(resultJson.code == 1){
									View.render("#notice-search-list-template", resultJson, '#notice-list');
								} else {
									alert(resultJson.msg);
								};
							}, async);
		e.preventDefault();
		}
		
	if(selectedValue === "notice-readcount"){
		// 조회수 높은순
		let url = 'notice-readcount';
		let method = 'GET';
		let contentType = 'application/json;charset=UTF-8';
		let sendData = {};
		let async = true;
	
		Request.ajaxRequest(url, method, contentType, 
							sendData,
							function(resultJson){
								//code 1 일때 render, 아닐 때 msg 띄움
								if(resultJson.code == 1){
									View.render("#notice-search-list-template", resultJson, '#notice-list');
								} else {
									alert(resultJson.msg);
								};
							}, async);
		e.preventDefault();
		}
	
});

/******** 위시리스트 - 투어 클릭 wishlist-list **********/ 

$(document).on('click','#type-tour',function(e){
	// ajax로 리스트 부분만 검색된 리스트로 변경
	
	let userId = $('#wishlist-id').val();
	console.log(userId);
	let method = 'GET';
	let contentType = 'application/json;charset=UTF-8';
	let sendData = {};
	let async = true;
	
	Request.ajaxRequest(`wishlist-with-tour?userId=${userId}`, 
						method, contentType,
						sendData,
						function(resultJson) {
							//code 1 일때 render, 아닐 때 msg 띄움
							if (resultJson.code == 1) {
								View.render('#wishlist-tour-template', resultJson, '#wishlist-list');
							} else {
								alert(resultJson.msg);
							};
						}, async);
					e.preventDefault();

});

/******** 위시리스트 - 티켓 클릭 wishlist-list **********/ 

$(document).on('click','#type-ticket',function(e){
	// ajax로 리스트 부분만 검색된 리스트로 변경
	let userId = $('#wishlist-id').val();
	let method = 'GET';
	let contentType = 'application/json;charset=UTF-8';
	let sendData = {};
	let async = true;
	
	Request.ajaxRequest(`wishlist-with-ticket?userId=${userId}`, 
						method, contentType,
						sendData,
						function(resultJson) {
							//code 1 일때 render, 아닐 때 msg 띄움
							if (resultJson.code == 1) {
								View.render("#wishlist-ticket-template", resultJson, '#wishlist-list');
							} else {
								alert(resultJson.msg);
							};
						}, async);
					e.preventDefault();

});
