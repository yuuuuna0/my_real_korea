import * as View from "./view.js";
import * as Request from "./request.js";
/*
	이벤트 등록 할 태그의 id
	#tour-search-btn
	#sort-by
*/
// JSON.stringify() => 객체를 string 으로, JSON.parse() => string 을 객체로 만듦 


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
//2. 정렬
$(document).on('change',$('#sort-by,#city-checkbox,#toType-chceckbox'),aaa);
//$(document).on('change',"#city-checkbox",aaa);
$(document).on('click',"#tour-search-btn",aaa);

//3. 체크박스 하나만 선택하기
$('input[type="checkbox"][name="city-checkbox"]').click(function(){
	if($(this).prop('checked')){
		$('input[type="checkbox"]').prop('checked',false);
		$(this).prop('checked',true);
	}
});


function aaa(){
	
	let keyword=$('#tour-search-keyword').val();
	let cityNo;
	let toType;
	let sortOrder=$('#sort-by').val();
	console.log($('#city-checkbox:checked').length);
	console.log($('#toType-checkbox:checked').length);
	
	if($('#city-checkbox:checked').length==1){
		cityNo=$('#city-checkbox:checked').val();
	} else{
		cityNo=0;
	}
	if($('#toType-checkbox:checked').length==1){
		toType=$('#toType-checkbox:checked').val();
	} else{
		toType=0;
	}
	
	console.log(keyword);
	console.log(cityNo);
	console.log(toType);
	console.log(sortOrder);

	//가격 낮은순 
	let url= 'tour-list-ajax';
	let method='POST';
	let contentType='application/json;charset=UTF-8';
	let sendData={
		
			currentPage:"1",
			keyword:keyword,
			cityNo:cityNo,
			toType:toType,
			sortOrder:sortOrder
				};
	let async=true;
	Request.ajaxRequest(url,method,contentType,
						JSON.stringify(sendData),
						function(resultJson){
							//code=1 성공 -> render , 아닐때 msg
							if(resultJson.code==1){
								View.render('#tour-search-list-template',resultJson,'#tour-list')
							} else{
								alert(resultJson.msg);
							}
						},async);

};
