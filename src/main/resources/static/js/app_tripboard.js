import * as View from "./view.js";
import * as Request from "./request.js";


//동행게시판 검색
$(document).on('click','#tripboard-search-btn',function(e){
	getSearchList();
	e.preventDefault();
});
// 검색창 입력 후 엔터키 => 검색
$("#tripboard-search-keyword").keyup(e => {
	if (e.keyCode == 13) {
		getSearchList();
		e.preventDefault();
	}
});


function getSearchList() {
	
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
	
}

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

//동행게시판 모집상태별 정렬(모집중, 모집완료)
$(document).on('change', '#sort-by-status', function(e) {
	let selectedValue = $(this).val();
	console.log(selectedValue);
	
		let url = 'tripboard-status-list';
		let method = 'GET';
		let contentType = 'application/json;charset=UTF-8';
		let sendData = {tBoStatus:selectedValue};
		
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
		// 폼의 유효성 검사에서 실패한 요소에 커서 두기
		form.find(':invalid').first().focus();
		
		// 폼 유효성 검사 실패 시 이벤트 중지
		e.preventDefault();
		e.stopPropagation();
	} else {
		let url = 'tripboard';
		let method = 'POST';
		let formData = new FormData();
		let tBoImg = null;
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
		
		//업로드 파일 선택이 되었을 때 FormData에 추가
		let inputFile = $("input[type='file']");
		//파일이 선택되면 tBoImg가 선택된 파일로 지정
		if(inputFile.prop('files') && inputFile.prop('files').length > 0) {
			formData.append('file', inputFile.prop('files')[0]);
			let inputFileName = inputFile.prop('files')[0].name;
			console.log(inputFileName);
		}else {
			tBoImg = $('#tBoImg').val();
			formData.append('tBoImg', tBoImg);
		}
		
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
	let form = $('#tripboardModifyForm');
	
	if(form.get(0).checkValidity() === false) {
		// 폼의 유효성 검사에서 실패한 요소에 커서 두기
		form.find(':invalid').first().focus();
		
		// 폼 유효성 검사 실패 시 이벤트 중지
		e.preventDefault();
		e.stopPropagation();
	} else {
		let tBoNo = $('#modify-tBoNo').val();
		let url = `tripboard/${tBoNo}`;
		let method = 'PUT';
		let formData = new FormData();
		let tBoImg = $('#modify-tBoImg').val();
		let cityNo = $('input[name="cOptions"]:checked').val();
		let tBoStyle = $('input[name="sOoptions"]:checked').val();
		let tBoStatus;
		
		console.log('>>>>>>>'+tBoImg);
		
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
		formData.append('tBoStatus', tBoStatus);
		
		//업로드 파일 선택이 되었을 때만 FormData에 추가
		let inputFile = $("input[type='file']");
		//파일이 선택되면 tBoImg가 선택된 파일로 지정
		if(inputFile.prop('files') && inputFile.prop('files').length > 0) {
			formData.append('file', inputFile.prop('files')[0]);
			let inputFileName = inputFile.prop('files')[0].name;
			console.log(inputFileName);
		}else {
			//파일 선택이 안 되면 hidden으로 넣어 놓은 tBoImg 이미지로 선택
			formData.append('tBoImg', tBoImg);
		}
		
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
	}
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




