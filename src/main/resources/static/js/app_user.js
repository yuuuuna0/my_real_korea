import * as View from "./view.js";
import * as Request from "./request.js";

/************ user-login *************/

$(document).ready(function() {
  toastr.options = {
    "positionClass": "toast-bottom-right",
    "timeOut": "3000",
    "background-color": "rgba(0, 0, 0, 0)"
    /*
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut",
    "progressBar": true,
    */
  }
});

	
//로그인 액션
$(document).ready(function() {
  $('#login_btn').click(function() {
    if (document.f.userId.value == "") {
      toastr.error('아이디를 입력하십시오.');
      document.f.userId.focus();
      return false;
    }
    if (document.f.password.value == "") {
      toastr.error('비밀번호를 입력하십시오.');
      document.f.password.focus();
      return false;
    }

    $.ajax({
      url: './user-login',
      type: 'POST',
      data: JSON.stringify({
        userId: document.f.userId.value,
        password: document.f.password.value
      }),
      contentType: 'application/json',
      success: function(data) {
        if (data.status == 0) {
          window.location.replace(data.data); //이전 페이지로 이동
        } else if (data.status == 1) {
          View.render('#user-auth-template', {}, '#user-login');
        } else {
          toastr.error(data.message);
        }
      },
      error: function(xhr, status, error) {
        console.error(error);
        toastr.error('로그인에 실패했습니다.');
      }
    });
  });
});


//아이디, 비밀번호 찾기 폼
$('#menu-user-find').click(function(e){
	View.render('#user-find-template', {}, '#user-login');
	e.preventDefault();
});

// 프로필 수정 폼 
$(document).on('click', '#btn-user-modify-form', function(e) {
	Request.ajaxRequest('user-modify-form',
						'GET',
						'application/json;charset=UTF-8',
						{},
						function(resultJson) {
							if(resultJson.code == 1){
								View.render('#user-modify-form-template', resultJson, '#user-detail-form');
							} else {
								alert(resultJson.msg);
							}
						},
						true);
	e.preventDefault();
});

// 프로필 수정 완료 버튼 

$(document).on('click','#btn-user-modify-action',function(e) {
	
	
	if (document.f.password.value == "") {
		alert("비밀번호를 입력하세요.");
		f.password.focus();
		return false;
	}
	if (document.f.password2.value == "") {
		alert("비밀번호확인을 입력하세요.");
		f.password2.focus();
		return false;
	} 
	if (document.getElementsByName("password")[0].value !== document.getElementsByName("password2")[0].value) {
	    alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
	    return;
	  }
	
	let url = 'user-modify-form-action';
	let method = 'PUT';
	let formData = new FormData();
	let alcohol = $('input[name="aOptions"]:checked').val();
	let smoking = $('input[name="sOptions"]:checked').val();
	
	formData.append('userId', $('#userId').val());
	formData.append('password', $('#password').val());
	formData.append('nickname', $('#nickname').val());
	formData.append('phone', $('#phone').val());
	formData.append('email', $('#email').val());
	formData.append('brith', $('#brith').val());
	formData.append('address', $('#address').val());
	formData.append('alcohol',alcohol);
	formData.append('smoking',smoking);
	formData.append('introduce', $('#introduce').val());
	
	let async = true;
		
	$.ajax({
	    method : method,
	    url : url, 
	    data : formData,
	    processData: false,
	    contentType: false,
	    success : function(resultJson){
		
				//code 1 일때 render, 아닐 때 msg 띄움
				if(resultJson.code == 1){
						window.location.href = 'user-view'; 
				} else {
					alert(resultJson.msg);
				};
			},
	    err : function(err) {
	        alert(err.status);
	    },
	    async : async
	});
		e.preventDefault();
});

$("#file").on('change',function(){
  var fileName = $("#file").val();
  $(".upload-name").val(fileName);
});