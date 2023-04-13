import * as View from "./view.js";
import * as Request from "./request.js";
// JSON.stringify() => 객체를 string 으로, JSON.parse() => string 을 객체로 만듦 

/********* function *********/
function selectedTourList(){
	
	let keyword=$('#tour-search-keyword').val();
	let cityNo;
	let toType;
	let sortOrder=$('#sort-by').val();
	
	if($('#city-checkbox:checked').length==1){
		cityNo=$('#city-checkbox:checked').val();
	} else{
		cityNo=0;
	}
	if($('input[name="toType-checkbox"]:checked').length==1){
		toType=$('input[name="toType-checkbox"]:checked').val();
	} else{
		toType=0;
	}

	let url= 'tour-list-ajax';
	let method='POST';
	let contentType='application/json;charset=UTF-8';
	let sendData={
			currentPage:"1",
			keyword:keyword,
			cityNo:cityNo,
			toType:toType,
			sortOrder:sortOrder};
	let async=true;
	
	Request.ajaxRequest(url,method,contentType,
						JSON.stringify(sendData),	//json으로 보낼 때 전부 string화 해 줘야 한다.
						function(resultJson){
							//code=1 성공 -> render , 아닐때 msg
							if(resultJson.code==1){
								View.render('#tour-search-list-template',resultJson,'#tour-list')
							} else{
								alert(resultJson.msg);
							}
						},async);
};



//1. 검색, 필터, 정렬 한 투어리스트 
$(document).on('change',$('#sort-by,#city-checkbox,#toType-checkbox'),selectedTourList);
$(document).on('click',"#tour-search-btn",selectedTourList);

//2. 체크박스 하나만 선택하기
$('input[type="checkbox"][name="city-checkbox"]').click(function(){
	if($(this).prop('checked')){
		$('input[type="checkbox"][name="city-checkbox"]').prop('checked',false);
		$(this).prop('checked',true);
	}
});
$('input[type="checkbox"][name="toType-checkbox"]').click(function(){
	if($(this).prop('checked')){
		$('input[type="checkbox"][name="toType-checkbox"]').prop('checked',false);
		$(this).prop('checked',true);
	}
});



/*
//1. 투어 검색하기
$(document).on('click','#tour-search-btn',function(e){
	let keyword=$('#tour-search-keyword').val();
	let url=`tour-list-ajax/${keyword}`;
	let method='GET';
	let contentType='application/json;charset=UTF-8';
	let sendData={};
	let async= true;
	//sendData -----> JSON.stringfy() => 객체를 string으로, JSON.parse() => string을 객체로 만듦
	Request.ajaxRequest(url,method,contentType,sendData,
						function(resultJson){
							//code=1 성공 -> render , 아닐때 msg
							if(resultJson.code==1){
								View.render('#tour-search-list-template',resultJson,'#tour-list')
							} else{
								alert(resultJson.msg);
							}
						},async);
	e.preventDefault();	//이벤트의 기본동작 취소 -> 이벤트버블링,캡쳐링 중단 / 기본동작 취소 (ex.rendering
});
*/
