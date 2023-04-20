import * as View from "./view.js";
import * as Request from "./request.js";

$(document).on('click', '#comment_btn_delete', function(event) {
    event.preventDefault();
    let fCoNo = $(this).data("value");
    let fBoNo = $('#fBoNo-hidden-value').val();
    // let nno = $(this).data('fCoNo');
    // console.log(nno);
    console.log(fCoNo);
    console.log(fBoNo);

    $.ajax({
        type: 'DELETE',
        url: 'freeboardcomment/' + fCoNo,
        success: function(result) {
            // 삭제 후 notice-list 로 이동
            window.location.href = 'freeboard-detail?fBoNo=' + fBoNo;
        },
        error: function(xhr, status, error) {
            console.log(error);
        }
    });
});

// $(document).on('click', '#freeboardcomment-modify-action-btn', function(event) {
//     event.preventDefault();
//     let fBoNo = $('#fBoNo-hidden-value2').val();
//     let fCoNo = $('#fCoNo-hidden-value2').val();
//     let contentType = 'application/json;charset=UTF-8';
//     let sendData = {
//         fCoNo:$('#fCoNo-hidden-value2').val(),
//         fBoNo:$('#fBoNo-hidden-value2').val(),
//         fCommentContent:$('#fCoContent2').val(),
//         fCommentDate:$('#fCoDate2').val(),
//         userId:$('#fCoUserId2').val()
//     };
//     let async = true;
//     Request.ajaxRequest(contentType,
//         JSON.stringify(sendData));
//     $.ajax({
//         type: 'PUT',
//         url: 'freeboardcomment/'+ fCoNo,
//         success: function(result) {
//             // 삭제 후 notice-list 로 이동
//             window.location.href = 'freeboard-detail?fBoNo='+fBoNo;
//         },
//         error: function(xhr, status, error) {
//             console.log(error);
//         }
//     });
// });




$(document).on('click','#freeboardcomment-modify-action-btn',function(e){
    // ajax로 리스트 부분만 검색된 리스트로 변경
    // let fCoNo = $('#fCoNo-hidden-value2').val();
    let fCoNo = $(this).data("value");
    let fBoNo = $('#fBoNo-hidden-value2').val();
    let conetent = $('textarea[name="fCoContent2"]').val();
    let userId = $("h4[name='fCoUserId2']").text();
    let url = 'freeboardcomment/'+fCoNo;
    let method = 'PUT';
    let contentType = 'application/json;charset=UTF-8';
    console.log(fCoNo);
    console.log(conetent);
    console.log(fBoNo);
    console.log(userId);

    let sendData= {
        fcoNo: fCoNo,
        fboNo:$('#fBoNo-hidden-value2').val(),
        fcommentContent:conetent,
        fcommentDate:$('#fCoDate2').val(),
        userId: userId

    };
    let async = true;
    // JSON.stringify() => 객체를 string 으로, JSON.parse() => string 을 객체로 만듬
    Request.ajaxRequest(url, method, contentType,
        JSON.stringify(sendData),
        function(resultJson){
            //code 1 일때 render, 아닐 때 msg 띄움
            if(resultJson.code == 1){
                window.location.href = 'freeboard-detail?fBoNo='+fBoNo;
            } else {
                alert(resultJson.msg);
            };
        }, async);

    e.preventDefault();
});

// $(document).on('click','#freeboard-write-action',function(e){
//     let city;
//     // $(document).on('click', '#city_btn1, #city_btn2, #city_btn3, #city_btn4, #city_btn5, #city_btn6, #city_btn7', function(e) {
//     //     city = $(this).val(); // 선택된 버튼의 value 값을 가져옴
//     //     console.log(city); // 선택된 버튼의 값 출력
//     //     // 나머지 코드 작성
//     // });
//     // ajax로 리스트 부분만 검색된 리스트로 변경
//     // let fCoNo = $('#fCoNo-hidden-value2').val();
//     // let fCoNo = $(this).data("value");
//     // let fBoNo = $('#fBoNo-hidden-value2').val();
//     let fBoTitle =  $("#fBoTitle").val();
//     let fBoContent = $('textarea[name="fBoContent"]').val();
//     let userId = $("input[name='userId']").val();
//     let cityNo = parseInt($("input[name='cityNo']").val());
//      let url = 'freeboard';
//     let method = 'POST';
//     let contentType = 'application/json;charset=UTF-8';
//     // console.log(fCoNo);
//     console.log(fBoTitle);
//     console.log(fBoContent);
//     console.log(userId);
//     console.log(cityNo);
//
//     let sendData= {
//         // fcoNo: fCoNo,
//         // fboNo:$('#fBoNo-hidden-value2').val(),]
//         fBoDate:null,
//         fBoCount:0,
//         fBoTitle : fBoTitle,
//         fBoContent:fBoContent,
//         userId: userId,
//         // cityNo: cityNo,
//     };
//     let async = true;
//     // JSON.stringify() => 객체를 string 으로, JSON.parse() => string 을 객체로 만듬
//     Request.ajaxRequest(url, method, contentType,cityNo,
//         JSON.stringify(sendData),
//         function(resultJson){
//             //code 1 일때 render, 아닐 때 msg 띄움
//             if(resultJson.code == 1){
//                 window.location.href = 'freeboard-list';
//             } else {
//                 alert(resultJson.msg);
//             };
//         }, async);
//
//     e.preventDefault();
// });


$(document).on('click', '#freeboard-write-action', function(e){

    let url = 'freeboard';
    let method = 'POST';
    let formData = new FormData();
    let tBoImg = "이미지";
    let cityNo = $('input[name="options"]:checked').val();
    // $('input[name="options"]').on('click', function() {
    //     // Get the value of the clicked radio button
    //      let cityNo = $(this).val();
    //     // Pass the value to another function
    //     anotherFunction(cityNo);
    // });
    // console.log(cityNo);

    formData.append('fBoTitle', $('#fBoTitle').val());
    formData.append('fBoContent', $('#fBoContent').val());
    formData.append('cityNo', cityNo);
    formData.append('userId', $('#userId').val());


    console.log(formData);
//     console.log(fBoContent);
//     console.log(userId);
//     console.log(cityNo);

    let async = true;

    $.ajax({
        method : method,
        url : url,
        data : formData,
        processData : false,
        contentType: false,
        success : function(resultJson){
            if(resultJson.code == 1) {
                window.location.href='freeboard-list';
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








// $(document).on('click', '#freeboardcomment-modify-action-btn', function(e) {
// 	// ajax로 리스트 부분만 검색된 리스트로 변경
// 	// let fCoNo = $('#fCoNo-hidden-value2').val();
// 	let fCoNoStr = ($(this).data("value"));
// 	// let fCoNo = parseInt(fCoNoStr);
//
// 	let fBoNoStr = $('#fBoNo-hidden-value2').val();
// 	// let fBoNo = parseInt(fBoNoStr);
//
//
// 	let fCommentContent = $('#fCoContent3').val();
//
// 	// let date =  $('#fCoDate2').val();
// 	// let fcommentDateStr = $('small[name="fCoDate2"]').text();
// 	// var fcommentDate = new Date(fcommentDateStr);
// 	// let dateStr = $('#fCoDate2').val();
// 	// let date = new Date(Date.parse(dateStr));
// 	let userId = $("h4[name='fCoUserId2']").text();
// 	let url = 'freeboardcomment/' + fCoNo;
// 	let method = 'PUT';
// 	let contentType = 'application/json;charset=UTF-8';
//
// 	console.log(fCoNoStr);
// 	// console.log(fBoNoNumber);
// 	console.log(conetent);
// 	console.log(fcommentDateStr);
// 	console.log(userId);
//
// 	let sendData = {
// 		fCoNo : fCoNoStr ,
// 		fBoNo : fBoNoStr,
// 		fCommentContent: fCommentContent,
// 		// fCommentDate: fcommentDateStr,
// 		userId: userId
// 	};
// 	console.log(sendData);
// 	let async = true;
// 	// JSON.stringify() => 객체를 string 으로, JSON.parse() => string 을 객체로 만듬
// 	Request.ajaxRequest(url, method, contentType,
// 		JSON.stringify(sendData),
// 		function(resultJson) {
// 			//code 1 일때 render, 아닐 때 msg 띄움
// 			if (resultJson.code == 1) {
// 				// window.location.href = 'freeboard-detail?fBoNo=' + fBoNo;
// 			} else {
// 				alert(resultJson.msg);
// 			}
// 			;
// 		}, async);
//
// 	e.preventDefault();
// });



// $(document).on('click', '#"freeboardcomment-modify-form-btn2"', function(event) {
//     event.preventDefault();
//     // let fCoNo = $(comment_btn_delete).val()
//     let fCoNo = $('#comment_btn_delete').attr('value');
//     // let fCoNo = $('#fCoNo-hidden-value').val();
//     let fBoNo = $('#fBoNo-hidden-value').val();
//     // let nno = $(this).data('fCoNo');
//     // console.log(nno);
//     console.log(fCoNo);
//     $.ajax({
//         type: 'PUT',
//         url: 'freeboardcomment/'+ fCoNo,
//         success: function(result) {
//             // 삭제 후 notice-list 로 이동
//             window.location.href = 'freeboard-detail?fBoNo='+fBoNo;
//         },
//         error: function(xhr, status, error) {
//             console.log(error);
//         }
//     });
// });

// $(document).on('click', '#freeboardcomment-modify-form-btn', function(event) {
//     event.preventDefault();
//     // let fCoNo = $(comment_btn_delete).val()
//     let fCoNo = $('#comment_btn_delete').attr('value');
//     // let fCoNo = $('#fCoNo-hidden-value').val();
//     let fBoNo = $('#fBoNo-hidden-value').val();
//     // let nno = $(this).data('fCoNo');
//     // console.log(nno);
//     console.log(fCoNo);
//     $.ajax({
//         type: 'GET',
//         url: 'freeboardcomment/'+ fCoNo,
//         success: function(result) {
//             // 삭제 후 notice-list 로 이동
//             window.location.href = 'freeboard-detail?fBoNo='+fBoNo;
//         },
//         error: function(xhr, status, error) {
//             console.log(error);
//         }
//     });
// });
// $(document).on("click", "#freeboardcomment-modify-form-btn", function() {
//     var value = $(this).data("value");
//     console.log(value);
// });

$(document).on('click', '#freeboardcomment-modify-form-btn', function(e) {
    // ajax로 리스트 부분만 검색된 리스트로 변경
    // let fCoNo = $('#fCoNo-hidden-value').val();
    let fCoNo = $(this).data("value");
    let url = 'freeboardcomment/' + fCoNo;
    let method = 'GET';
    let contentType = 'application/json;charset=UTF-8';
    console.log(fCoNo);

    let sendData = {
        // fCoNo:73,
        // fCoNo:$(getElementById('freeboardcomment-modify-form-btn')),
        // fCoNo: fCoNo,
        // // fCoNo:$('#freeboardcomment-modify-form-btn').val(),
        // fBoNo: $('#fBoNo-hidden-value').val(),
        //
        // fCommentContent: $('#fCoContent').val(),
        // fCommentDate: $('#fCoDate').val(),
        // userId: $('#fCoUserId').val()
    };
    // }
    let async = true;
    // JSON.stringify() => 객체를 string 으로, JSON.parse() => string 을 객체로 만듬
    Request.ajaxRequest(url, method, contentType, sendData,
        // JSON.stringify(sendData),
        function(resultJson) {
            //code 1 일때 render, 아닐 때 msg 띄움
            if (resultJson.code == 1) {
                View.render("#freeBoardCommentModifyForm", resultJson, '#comments');
            } else {
                alert(resultJson.msg);
            }
            ;
        }, async);

    e.preventDefault();
});


// $.ajax({
//     type: 'GET',
//     url: 'freeboardcomment/'+ fCoNo,
//     success: function(result) {
//         // 삭제 후 notice-list 로 이동
//         // window.location.href = 'freeboard-detail?fBoNo='+fBoNo;
//     },
//     error: function(xhr, status, error) {
//         console.log(error);
//     }
// });


// $(document).on('click', '#comment_btn_delete', function(event) {
//     let fCoNo = $(this).value;
//     // let pageno = $(this).attr("pageno");
//     location.href = `freeboard-comment-delete-action`;
// });


//  $(document).on('click', '#comment_btn_delete', function(event) {
//     let fCoNo = $(this).value;
//     console.log(fCoNo);
//     ToastConfirm.fire({ icon: 'question',
//         title: "게시글을 삭제하시겠습니까?\n 삭제 후 복구가 불가능합니다"}).then((result) => {
//         if(result.isConfirmed){
//             $.ajax({
//                 url: "notice_delete_rest",
//                 method: "post",
//                 data: {"fCoNo":fCoNo},
//                 dataType: "json",
//                 success:function(resultObj){
//                     if(resultObj.errorCode > 0){
//                         Toast.fire({ icon: 'success', title: resultObj.errorMsg }).then((result) => {
//                             location.href = "freeboard-list";
//                         });
//                     }else{
//                         Toast.fire({ icon: 'error', title: resultObj.errorMsg });
//                     }
//                 }
//             });
//         }
//     });
// });