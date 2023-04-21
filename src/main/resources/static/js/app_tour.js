import * as View from "./view.js";
import * as Request from "./request.js";
// JSON.stringify() => 객체를 string 으로, JSON.parse() => string 을 객체로 만듦 

/********* function ********/
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
			pageNo:"1",
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
$(document).on('change','#sort-by,#city-checkbox,#toType-checkbox',selectedTourList);
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

//3. 투어리뷰 남기기
// 3-1. 로그인상태면 모달 내 이름에 아이디 넣어주기
$(document).on('show.bs.modal','#myReviewModal',function(){
	let userId=$('#myReviewBtn').data('id');
	  $('#myReviewModal').find('#userIdM').val(userId);
});
//3-2. 리뷰남기기 버튼 클릭시
$(document).on('click','#submitReviewBtn',function(e){

	/****************** 1. form으로 전달하는 방법 *************/
	let form=$('tourReviewF');
	if(/*form.get(0).checkValidity()===*/false){
		//폼 유효성 검사 실패시 
		form.find(':invalid').first().focus();	//폼 유효성 검사 실패한 요소에 커서 두기
		//이벤트 중지
		e.preventDefault();
		e.stopPropagation();
	} else{
		//폼 유효성 검사 성공시
		let url="tour-review-action";
		let method="POST";
		let async=true;
		let formData=new FormData();
		let toReviewImg;
		
		formData.append('toNo',$('#toNoM').val());
		formData.append('userId',$('#userIdM').val());
		formData.append('toReviewTitle',$('#toReviewTitleM').val());
		formData.append('toReviewStar',$('#toReviewStarM').val());
		formData.append('toReviewContent',$('#toReviewContentM').val());
		
		let uploadImg=$('#toReviewUploadM');
		//이미지 업로드시 & 업로드 안할 시 나눠서 처리함 
		if(uploadImg.prop('files') && uploadImg.prop('files').length>0){
			//파일 업로드시 업로드한 이미지 폼데이터에 추가 
			formData.append('file',uploadImg.prop('files')[0]);
		} else{
			//파일 선택 안되면 hidden으로 넣은 toReviewImg 선택해서 폼데이터에 추가
			//toReviewImg=$('toReviewImgM').val();
			formData.append('toReviewImg',toReviewImg);
		}
	$('#myReviewModal').modal('hide');	//모달 창 닫기
	$('#tourReviewF')[0].reset();
	
	$.ajax({
		method:method,
		url:url,
		data:formData,
		processData:false,
		contentType:false,
		success:function(resultJson){
			if(resultJson.code==1){
				//window.location.href=`tour-detail?toNo=${formData.get('toNo')}`;
				View.render("#tourReview-template",resultJson,'#tourReviewDiv');
			} else{
				alert(resultJson.msg);
			}
		},
		error:function(err){
			alert(err.status);
		},
		async:async
	});
		e.preventDefault();	////폼 제출 방지
	}
	
	/***************** 2. 데이터 하나하나 전달하는 방법 **********
	//이미지랑 별점 해결해야함
	let toNo=$('#toNoM').val();
	let userId=$('#userIdM').val();
	let toReviewTitle=$('#toReviewTitleM').val();
	let toReviewStar=$('#toReviewStarM').val();	//undefined
	let toReviewContent=$('#toReviewContentM').val();
	let toReviewImg=$('#toReviewImg').val();
	let sendData={
		toNo:toNo,
		userId:userId,
		toReviewTitle:toReviewTitle,
		toReviewStar:toReviewStar,
		toReviewContent:toReviewContent,
		toReviewImg:toReviewImg
	};
	******************************************************/
});
	
//4. 투어리뷰 삭제
$(document).on('click',"button[name='deleteToReview']",function(e){
	let urlSearchParams=new URLSearchParams(window.location.search);
	
	let toNo=urlSearchParams.get('toNo');
	let toReviewNo=e.target.value;
	console.log(toNo);
	let url= `tour-review-delete/${toNo}/${toReviewNo}`;
	let method='DELETE';
	let contentType='application/json;charset=UTF-8';
	let sendData={};
	let async=true;
	
	Request.ajaxRequest(url,method,contentType,
						JSON.stringify(sendData),	//json으로 보낼 때 전부 string화 해 줘야 한다.
						function(resultJson){
							//code=1 성공 -> render , 아닐때 msg
							if(resultJson.code==1){
								//window.location.href=`tour-detail?toNo=${toNo}`;
								View.render("#tourReview-template",resultJson,'#tourReviewDiv');
							} else{
								alert(resultJson.msg);
							}
						},async);
});

//5. 투어 결제하기 (API 적용)
$(document).on('click','#tourPayment',function(e){
	e.preventDefault();
	e.stopPropagation();
	
	let IMP = window.IMP; // 생략 가능
	IMP.init("imp43548145"); // 예: imp00000000a
	
	let pMethod;
	if('#pMethod'.val==3){
		pMethod='card';
	}
	/********** 자바스크립트에서 세션 값 가져오는거 먼저 해야 함!!  ***** */
    IMP.request_pay({
      pg: "html5_inicis",
      pay_method: pMethod,
      merchant_uid: "[[${session.payment.toNo}]]",   // 주문번호
      name: "[[${session.payment.toName}]]",
      //amount: "[[${{session.payment.pPrice}}]]",                         // 숫자 타입
      amount: 100,                        // 숫자 타입
     // buyer_email: "[[${session.loginUser.email}]]",
      buyer_email: "jyn9306@naver.com",
      buyer_name: "[[${session.loginUser.name}]]",
      buyer_tel: "[[${session.loginUser.phone}]]",
      buyer_addr: "[[${session.loginUser.address}]]"
    }, function (rsp) { // callback
    	console.log(rsp);
      if (rsp.success) {
        // 결제 성공 시 로직
			document.rsPInfoF.action='tour-payment-action';
			document.rsPInfoF.submit();
      } else {
        // 결제 실패 시 로직
        alert
      }
    });
	
	
	
});

function tourPaymentAction(){
			
}


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
