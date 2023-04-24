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
	
	let curPage = $('#cur-page');
	let totRecordCount = $('#tot-record-count');
	
	Request.ajaxRequest(url, method, contentType, sendData,
						function(resultJson){
							curPage.text(resultJson.data.pageMaker.curPage);
							totRecordCount.text(resultJson.data.pageMaker.totCount);
							
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
		
		let curPage = $('#cur-page');
		let totRecordCount = $('#tot-record-count');
		
		Request.ajaxRequest(url, method, contentType, sendData,
							function(resultJson){
								curPage.text(resultJson.data.pageMaker.curPage);
								totRecordCount.text(resultJson.data.pageMaker.totCount);
								
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
		
		let curPage = $('#cur-page');
		let totRecordCount = $('#tot-record-count');
		
		Request.ajaxRequest(url, method, contentType, sendData,
							function(resultJson){
								curPage.text(resultJson.data.pageMaker.curPage);
								totRecordCount.text(resultJson.data.pageMaker.totCount);
								
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
		
		let curPage = $('#cur-page');
		let totRecordCount = $('#tot-record-count');
		
		Request.ajaxRequest(url, method, contentType, 
							sendData,
							function(resultJson){
								curPage.text(resultJson.data.pageMaker.curPage);
								totRecordCount.text(resultJson.data.pageMaker.totCount);
								
								if(resultJson.code == 1){
									View.render('#tripboard-search-list-template', resultJson, '#tripboard-list');
								}else {
									alert(resultJson.msg);
								}
							}, async);
		e.preventDefault();
});

//동행게시판 글쓰기 액션
$(document).on('click', '#tripboard-write-action', function(e){
	let form = $('#tripboardWriteForm');
	
	if(form.get(0).checkValidity() === false) {
		form.find(':invalid').first().focus();
		e.preventDefault();
		e.stopPropagation();
	} else {
		let url = 'tripboard';
		let method = 'POST';
		let formData = new FormData();
		let tBoImg = "이미지";
		let cityNo = $('input[name="cOptions"]:checked').val();
		let tBoStyle = $('input[name="sOoptions"]:checked').val();
		
		formData.append('tBoTitle', $('#tBoTitle').val());
		formData.append('tBoContent', $('#tBoContent').val());
		formData.append('tBoPerson', $('#tBoPerson').val());
		formData.append('tBoStartDate', $('#tBoStartDate').val());
		formData.append('tBoEndDate', $('#tBoEndDate').val());
		formData.append('tBoStyle', tBoStyle);
		formData.append('hashtag', $('#hashtag').val());
		formData.append('cityNo', cityNo);
		formData.append('userId', $('#userId').val());
		formData.append('tBoImg', tBoImg);
		
		let async = true;
		
		$.ajax({
			method : method,
			url : url,
			data : formData,
			processData : false,
			contentType: false,
			success : function(resultJson){
				if(resultJson.code == 1) {
					window.location.href='tripboard-list';
				}else {
					alert(resultJson.msg);
				}
			},
			error : function(err) {
				alert(err.status);
			},
			async : async
		});
		e.preventDefault();
	}
});

function checkedStatus(event) {
 		let result='';
 		if(event.target.checked) {
 			result = '0';
 		}else {
 			result = '1';
 		}
 		
 		console.log(result);
 		result = document.f.tBoStatus.value;
 		return result;
 	}

//동행게시판 수정 액션
$(document).on('click', '#tripboard-modify-action', function(e){
	let form = $('#tripboardWriteForm');
	let tBoNo = $('#modify-tBoNo').val();
	let url = `tripboard/${tBoNo}`;
	let method = 'PUT';
	let formData = new FormData();
	let cityNo = $('input[name="cOptions"]:checked').val();
	let tBoStyle = $('input[name="sOoptions"]:checked').val();
	let tBoStatus;
	
	if(document.getElementById("tBoStatus").checked) {
		tBoStatus = '0';
	}else {
		tBoStatus = '1';
	}
	
	formData.append('tBoTitle', $('#tBoTitle').val());
	formData.append('tBoContent', $('#tBoContent').val());
	formData.append('tBoPerson', $('#tBoPerson').val());
	formData.append('tBoStartDate', $('#tBoStartDate').val());
	formData.append('tBoEndDate', $('#tBoEndDate').val());
	formData.append('tBoStyle', tBoStyle);
	formData.append('hashtag', $('#hashtag').val());
	formData.append('cityNo', cityNo);
	formData.append('userId', $('#userId').val());
	formData.append('tBoImg', $('#userId').val());
	formData.append('tBoStatus', tBoStatus);
	
	let async = true;
	
	$.ajax({
		method : method,
		url : url,
		data : formData,
		processData : false,
		contentType: false,
		success : function(resultJson){
			if(resultJson.code == 1) {
				window.location.href=`tripboard-detail?tBoNo=${tBoNo}`;
			}else {
				alert(resultJson.msg);
			}
		},
		error : function(err) {
			alert(err.status);
		},
		async : async
	});
	e.preventDefault();
});

//동행게시판 게시글 삭제
$(document).on('click', '#tripboard-delete-action-btn', function(event) {
	event.preventDefault();
	let tBoNo = $('#delete-tBoNo').val();
	
	$.ajax({
		type:'DELETE',
		url:'tripboard/' + tBoNo,
		success:function(result) {
			window.location.href='tripboard-list';
		},
		error:function(xhr, status, error) {
			console.log(error);
		}
	});
});

//동행게시판 댓글 삭제
$(document).on('click', '#comment_btn_delete', function(event) {
    event.preventDefault();
    let tCoNo = $(this).data("value");
    let tBoNo = $('#tBoNo-hidden-value').val();
    
    console.log(tCoNo);
    console.log(tBoNo);

    $.ajax({
        type: 'DELETE',
        url: 'tripboardcommentdeleteaction/' + tCoNo,
        success: function(result) {
            // 삭제 후 tripboard-detail로 상태유지
            window.location.href = 'tripboard-detail?tBoNo=' + tBoNo;
        },
        error: function(xhr, status, error) {
            console.log(error);
        }
    });
});


//동행게시판 댓글 수정 폼
$(document).on('click', '#tripboardcomment-modify-form-btn', function(e) {
 
    let tCoNo = $(this).attr("data-value");
    let url = 'tripboardcomment/' + tCoNo;
    let method = 'GET';
    let contentType = 'application/json;charset=UTF-8';
    console.log(tCoNo);

    let sendData = {};
    let async = true;
   
    
    Request.ajaxRequest(url, method, contentType, sendData,
      
        function(resultJson) {
          
            if (resultJson.code == 1) {
                View.render("#tripBoardCommentModifyForm", resultJson, '#comments');
            } else {
                alert(resultJson.msg);
            }
            ;
        }, async);

    e.preventDefault();
});

// 동행게시판 댓글 수정 액션
$(document).on('click','#tripboardcomment-modify-action-btn',function(e){
   
    let tCoNo = $(this).data("value");
    let tBoNo = $('#tBoNo-hidden-value2').val();
    let tcommentContent = $('textarea[name="tCoContent2"]').val();
    let userId = $("h4[name='tCoUserId2']").text();
    let url = 'tripboardcommentupdateaction/'+tCoNo;
    let method = 'PUT';
    let contentType = 'application/json;charset=UTF-8';
    let tcommentDate = $('#tCoDate2').val();
    
    console.log('tCoNo'+tCoNo);
    console.log('tcommentContent'+tcommentContent);
    console.log('tBoNo'+tBoNo);
    console.log('tCoDate'+ tcommentDate);
    console.log('userId'+userId);

    let sendData= {
        tcoNo: tCoNo,
        tboNo: tBoNo,
        tcommentContent:tcommentContent,
        tcommentDate:tcommentDate,
        userId: userId
    };
    let async = true;
    
    // JSON.stringify() => 객체를 string 으로, JSON.parse() => string 을 객체로 만듬
    Request.ajaxRequest(url, method, contentType,
        JSON.stringify(sendData),
        function(resultJson){
            //code 1 일때 render, 아닐 때 msg 띄움
            if(resultJson.code == 1){
                window.location.href = 'tripboard-detail?tBoNo='+tBoNo;
                 console.log('###################');
                // View.render("#tripBoardCommentModifyAction", resultJson, '#tripboardcomment-detail');
            } else {
                alert(resultJson.msg);
            };
        }, async);

    e.preventDefault();
});




