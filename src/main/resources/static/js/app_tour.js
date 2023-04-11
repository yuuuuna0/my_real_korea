import * as View from "./view.js";
import * as Request from "./request.js";
/*
	이벤트 등록 할 태그의 id
	#tour-search-btn
	#sort-by
*/

//1. 투어 검색하기
$(document).on('click','#tour-search-btn',function(e){
	let keyword=$('#tour-search-keyword').val();
	let url=`tour-list-ajax/${keyword}`;
	let method='GET';
	let contentType='application/json;charset=UTF-8';
	let sendData={};
	let async= true;
	//JSON.stringfy() => 객체를 string으로, JSON.parse() => string을 객체로 만듦
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
//2. 정렬
$(document).on('change','#sort-by',function(e){
	let selectedValue=$(this).val();
	if(selectecValue === "toNoAsc"){
		
	} else if(selectecValue === "toPriceAc"){
		
	} else if(selectecValue === "toPriceDesc"){
		
	} else if(selectecValue === "toCountAsc"){
		
	} else if(selectecValue === "toCountDesc"){
		
	}
});

