import * as View from "./view.js";
import * as Request from "./request.js";

/************************* login *************************/

//토스트
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

//회원 가입 폼
$(document).on('click','#btn-user-join',function() {
	location.href="user-write";
});
	
//로그인 액션
$(document).on('click','#btn-user-login',function(e) {
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
    e.preventDefault();	
});


//아이디, 비밀번호 찾기 폼
$('#menu-user-find').click(function(e){
	View.render('#user-find-template', {}, '#user-login');
	e.preventDefault();
});

//아이디 찾기 액션
$(document).on('click','#btn-user-find-id',function(e) {

    let name = $('#name').val();
    let email = $('#email').val();
    
    
    if (name == "") {
    	toastr.error("이름을 입력하세요.");
        document.i.name.focus();
        return false;
    }
    if (email == "") {
    	toastr.error("이메일을 입력하세요.");
        document.i.email.focus();
        return false;
    }

    $.ajax({
        type: "POST",
        url: "./user-find-id-action",
        dataType: "json",
        data: {
            name: name,
            email: email
        },
        success: function(response) {
            if (response.status == 1) {
            	alert(response.message);
            } else if (response.status == 2) {
            	alert(response.message);
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
        }
    });
    e.preventDefault();
});

//비밀번호 찾기 액션
$(document).on('click','#btn-user-find-pw',function(e) {
  const userId = document.p.userId.value;
  const email = document.p.email.value;

  if (userId === "") {
	  toastr.error("아이디를 입력하십시오.");
    document.p.name.focus();
    return false;
  }

  if (email === "") {
	  toastr.error("이메일을 입력하십시오.");
    document.p.email.focus();
    return false;
  }

  const data = {
    userId: userId,
    email: email,
  };

  $.ajax({
    type: "POST",
    url: "./user-find-pw-action",
    data: data,
    dataType: "json",
    success: function (response) {
      if (response.status == 1) {
        alert(response.message);
        window.location.replace("user-login");
      } else {
        alert(response.message);
      }
    },
    error: function (xhr, status, error) {
      console.error(error);
      alert("오류가 발생했습니다.");
    },
  });
  e.preventDefault();
  return true;
});

//이메일 인증 액션
$(document).on('click','#btn-user-auth',function(e) {
    let mailAuthKey = $("input[name='mailAuthKey']").val();
    $.post({
        url: "./user-auth-action",
        data: { mailAuthKey: mailAuthKey },
        success: function(response) {
            if (response.status === 0) {
                // 인증 성공
                window.location.replace(response.data);
                toastr("인증 성공! 로그인 페이지로 이동합니다.")
            } else {
                // 인증 실패
                toastr.error("인증 코드가 일치하지 않습니다.");
            }
        },
        error: function(xhr) {
            alert("서버 오류가 발생했습니다.");
        }

    });
      e.preventDefault();
});


/************************* write *************************/

//아이디 중복검사 후 true 반환
let isIdChecked = false;


//아이디 유효성 검사, 중복 체크
$(document).on('click','#btn-user-id-check',function(e) {
	const idValidate = /^[a-z][-_.a-z0-9]{5,11}$/g;
	const userId = $('#userId').val().trim();

	if (!idValidate.test(userId)) {
		toastr.error('사용 불가능한 아이디 형식입니다.');
		return $('#userId').val('');
	}
	if (userId === '') {
		toastr.error('아이디를 입력해주세요.');
		return;
	}

		$.ajax({
			url: './idCheck',
			type: 'post',
    	    data: { userId: userId },
    	    success: function(cnt) {
				if (cnt == 0) {
					alert('사용 가능한 아이디입니다.');
					isIdChecked = true;
				} else {
					alert('이미 사용중인 아이디입니다.');
					$('#userId').val('');
				}
			},
			error: function() {
				alert('에러입니다.');
    	    }
		});
		e.preventDefault();	
});




//비밀번호 유효성 검사
$(document).ready(function() {
	let password1 		= $('#password1');
	let password2		= $('#password2');
	let passwordsInfo 	= $('#pass-info');
	
	validatePassword(password1,password2,passwordsInfo);
	
});

function validatePassword(password1, password2, passwordsInfo){

	$(password1).on('keyup', function(e) {
	let password = document.getElementById("password1").value;
	
		if(/[^a-zA-Z0-9~!@#$%^&*()_+,.?]/.test(password)) {
			const invalidChar = password.match(/([^a-zA-Z0-9~!@#$%^&*()_+,.?])/)[1];
			passwordsInfo.removeClass().addClass('stillweakpass')
			.html("허용되지 않는 문자 "+invalidChar+" 가 포함되어 있습니다.");
		}	
		else if(/(.)\1\1/.test(password)) {
			passwordsInfo.removeClass().addClass('stillweakpass')
			.html("같은 문자를 연속으로 3개 이상 사용할 수 없습니다.");
		}	
		else if(password.length < 8 || password.length > 12) {
			passwordsInfo.removeClass().addClass('weakpass')
			.html("비밀번호는 8글자 이상 12글자 이하여야 합니다.");
		}
		else if(!/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+,.?])/.test(password)) {
			passwordsInfo.removeClass().addClass('stillweakpass')
			.html("영어, 숫자, 특수문자를 모두 포함해야 합니다.");
    	}
		else {
			passwordsInfo.removeClass().addClass('goodpass')
			.html("사용 가능한 비밀번호 입니다.");
			return true;
		}
		e.preventDefault();	
	});
	
	$(password2).on('keyup', function(e) {
		
		if(password1.val() !== password2.val()) {
			passwordsInfo.removeClass().addClass('weakpass').html("비밀번호 확인이 일치하지 않습니다.");	
		}else{
			passwordsInfo.removeClass().addClass('goodpass').html("비밀번호 확인이 일치합니다.");	
		}
		e.preventDefault();	
	});
}
//회원 가입
$(document).on('click','#btn-user-create',function(e) {
    	
	  var user = {};
	  user.userId = $("#userId").val();
	  user.password = $("#password1").val();
	  user.password2 = $("#password2").val();
	  user.name = $("input[name=name]").val();
	  user.nickname = $("input[name=nickname]").val();
	  user.phone = $("input[name=phone]").val();
	  user.email = $("input[name=email]").val();
	  user.birth = $("input[name=birth]").val();
	  user.address = $("input[name=address]").val();
	  user.gender = $("input[name=gender]:checked").val();
	  
	  
	const termsService = document.getElementById("termsService");
	const termsPrivacy = document.getElementById("termsPrivacy");
		  
	if (!termsService.checked || !termsPrivacy.checked) {
		toastr.error("이용 약관에 모두 동의해주세요.");
		return false;
	}
	if (user.userId === "") {
		toastr.error("사용자 아이디를 입력하세요.");
	    $("#userId").focus();
	    return false;
	}
	if (!isIdChecked) {
		toastr.error("아이디 중복 확인 버튼을 클릭해주세요.");
	    return false;
	}
	if (user.password !== user.password2) {
		toastr.error("비밀번호와 비밀번호 확인은 일치해야 합니다.");
	    $("#password2").focus().select();
	    return false;
	}
	if (!validatePassword()) {
		return false;
	}
	if (user.name === "") {
	    toastr.error("이름을 입력하세요.");
	    $("input[name=name]").focus();
	    return false;
	}
	if (user.nickname === "") {
	    toastr.error("닉네임을 입력하세요.");
	    $("input[name=nickname]").focus();
	    return false;
	}
	if (user.phone === "") {
		toastr.error("휴대폰 번호를 입력하세요.");
	    $("input[name=phone]").focus();
		return false;
	}
	if (user.email === "") {
		toastr.error("이메일 주소를 입력하세요.");
	    $("input[name=email]").focus();
		return false;
	}
	if (user.birth === "") {
		toastr.error("생년월일을 입력하세요.");
	    $("input[name=birth]").focus();
		return false;
	}
	if (user.address === "") {
		toastr.error("주소를 입력하세요.");
	    $("input[name=address]").focus();
		return false;
	}
	if (user.gender === "") {
		toastr.error("성별을 선택하세요.");
	    $("input[name=gender]").focus();
		return false;
	}
	$.ajax({
	    type: "POST",
	    url: "./user-write-action",
	    data: JSON.stringify(user),
	    dataType: "json",
	    contentType: "application/json;charset=UTF-8",
	    success: function (data) {
	        if (data.status == 0) {
	            toastr(data.message);
	            window.location.href = "./index";
	        } else {
	            alert(data.message);
	        }
	    },
	    error: function (xhr, status, error) {
	        console.error(error);
	        alert("회원가입에 실패했습니다.");
	    }
	}); 
	e.preventDefault();		
});
/******************************************************************/


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
	let gender = $('input[name="gOptions"]:checked').val();
	let alcohol = $('input[name="aOptions"]:checked').val();
	let smoking = $('input[name="sOptions"]:checked').val();
	
	formData.append('userId', $('#userId').val());
	formData.append('password', $('#password').val());
	formData.append('nickname', $('#nickname').val());
	formData.append('phone', $('#phone').val());
	formData.append('email', $('#email').val());
	formData.append('brith', $('#brith').val());
	formData.append('address', $('#address').val());
	formData.append('gender', gender);
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