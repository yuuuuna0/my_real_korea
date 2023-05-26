import * as View from "./view.js";
import * as Request from "./request.js";


Handlebars.registerHelper('dateformat', function (date) {
    // 날짜 포맷 변환 로직 작성
});


$(document).on('click', '#comment_btn_delete', function (event) {
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
        success: function (result) {
            // 삭제 후 notice-list 로 이동
            window.location.href = 'freeboard-detail?fBoNo=' + fBoNo;
        },
        error: function (xhr, status, error) {
            console.log(error);
        }
    });
});


$(document).on('click', '#freeboardcomment-modify-action-btn', function (e) {
    let form = $('#freeboardModifyForm');

    if (form.get(0).checkValidity() === false) {
        // 폼의 유효성 검사에서 실패한 요소에 커서 두기
        form.find(':invalid').first().focus();

        // 폼 유효성 검사 실패 시 이벤트 중지
        e.preventDefault();
        e.stopPropagation();
    } else {
        let fCoNo = $(this).data("value");
        let fBoNo = $('#fBoNo-hidden-value2').val();
        let conetent = $('textarea[name="fCoContent2"]').val();
        let userId = $("h4[name='fCoUserId2']").text();
        let url = 'freeboardcomment/' + fCoNo;
        let method = 'PUT';
        let contentType = 'application/json;charset=UTF-8';
        console.log(fCoNo);
        console.log(conetent);
        console.log(fBoNo);
        console.log(userId);

        let sendData = {
            fcoNo: fCoNo,
            fboNo: $('#fBoNo-hidden-value2').val(),
            fcommentContent: conetent,
            fcommentDate: $('#fCoDate2').val(),
            userId: userId

        };
        let async = true;
        // JSON.stringify() => 객체를 string 으로, JSON.parse() => string 을 객체로 만듬
        Request.ajaxRequest(url, method, contentType,
            JSON.stringify(sendData),
            function (resultJson) {
                //code 1 일때 render, 아닐 때 msg 띄움
                if (resultJson.code == 1) {
                    window.location.href = 'freeboard-detail?fBoNo=' + fBoNo;
                } else {
                    alert(resultJson.msg);
                }
                ;
            }, async);

        e.preventDefault();
    }
});


$(document).on('click', '#freeboard-write-action', function (e) {
    let form = $('#freeboardWriteForm');
    console.log(form);
    if (form.get(0).checkValidity() === false) {
        // 폼의 유효성 검사에서 실패한 요소에 커서 두기
        form.find(':invalid').first().focus();
        // 폼 유효성 검사 실패 시 이벤트 중지
        e.preventDefault();
        e.stopPropagation();
    } else {
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
        let id = $('#userId').val();
        console.log(id);
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
            method: method,
            url: url,
            data: formData,
            processData: false,
            contentType: false,
            success: function (resultJson) {
                if (resultJson.code == 1) {
                    window.location.href = 'freeboard-list';
                } else {
                    alert(resultJson.msg);
                }
            },
            error: function (err) {
                alert(err.status);
            },
            async: async
        });
        e.preventDefault();
    }
});


$(document).on('click', '#freeboard-modify-action', function (e) {
    let form = $('#freeboardModifyForm');
    console.log(form);
    if (form.get(0).checkValidity() === false) {
        // 폼의 유효성 검사에서 실패한 요소에 커서 두기
        form.find(':invalid').first().focus();
        // 폼 유효성 검사 실패 시 이벤트 중지
        e.preventDefault();
        e.stopPropagation();
    } else {
        let fBoNo = $('#fBoNo-hidden-value').val();
        let url = 'freeboardModify';
        let method = 'PUT';
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
        formData.append('fBoNo', $('#fBoNo-hidden-value').val());
        formData.append('fBoContent', $('#fBoContent').val());
        formData.append('fBoCount', $('#fBoCount-hidden-value').val());
        formData.append('cityNo', cityNo);
        formData.append('userId', $('#userId').val());


        console.log(formData);
//     console.log(fBoContent);
//     console.log(userId);
//     console.log(cityNo);

        let async = true;

        $.ajax({
            method: method,
            url: url,
            data: formData,
            processData: false,
            contentType: false,
            success: function (resultJson) {
                if (resultJson.code == 1) {
                    window.location.href = 'freeboard-detail?fBoNo=' + fBoNo;
                } else {
                    alert(resultJson.msg);
                }
            },
            error: function (err) {
                alert(err.status);
            },
            async: async
        });
        e.preventDefault();
    }
});


$(document).on('click', '#freeboardcomment-modify-form-btn', function (e) {
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
        function (resultJson) {
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


