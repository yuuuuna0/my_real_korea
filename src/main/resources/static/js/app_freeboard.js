import * as View from "./view.js";
import * as Request from "./request.js";

//동행게시판 필터(사이드바 전체보기, 지역별 보기)
$(document).on('click', '#all-city-list', function getCityList(e) {
	let cityNo=$(this).attr('name');
	let pageNo=1;
		location.href=`freeboard-city-list?cityNo=${cityNo}&pageNo=${pageNo}`;
				e.preventDefault();
});

$("#freeboard-search-keyword").keyup(e => {
	if (e.keyCode == 13) {
		getSearchList(e);
		e.preventDefault();
	}
});
// 검색창 입력 후 직접 검색버튼 클릭 => 검색
$(document).on('click','#freeboard-search-btn',function(e){
	getSearchList(e);
	e.preventDefault();
});

function getSearchList(e){
	// ajax로 리스트 부분만 검색된 리스트로 변경
	let keyword = $('#freeboard-search-keyword').val();
	let url = `freeBoard-search?pageNo=1&keyword=${keyword}`;
	let method = 'GET';
	let contentType = 'application/json;charset=UTF-8';
	let sendData;
	let async = true;
	
	// 키워드 결과, 현재 페이지 숫자 표시
	let curPage=$('#cur-page');
	console.log(curPage);
	let totRecordCount=$('#tot-record-count');
	// JSON.stringify() => 객체를 string 으로, JSON.parse() => string 을 객체로 만듬
	Request.ajaxRequest(url, method, contentType, 
						JSON.stringify(sendData),
						function(resultJson){
							//페이지 정보 변경
							curPage.text(resultJson.data.pageMaker.curPage);
							totRecordCount.text(resultJson.data.pageMaker.totCount);
							
							//code 1 일때 render, 아닐 때 msg 띄움
							if(resultJson.code == 1){
								View.render("#freeboard-search-list-template", resultJson, '#freeboard-list');
							} else {
								alert(resultJson.msg);
							};
						}, async);
	
	e.preventDefault();
};
//2. 체크박스 하나만 선택하기
$('input[type="radio"][name="city-radio"]').click(function(){
	if($(this).prop('checked')){
		$('input[type="radio"][name="city-radio"]').prop('checked',false);
		$(this).prop('checked',true);
	}
});

