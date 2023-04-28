import * as View from "./view.js";
import * as Request from "./request.js";

/************** 마이페이지 ************/
//1. 예약 삭제
$(document).on('click',"button[name='deletePayement']",function(e){
	let pNo=e.target.value;
	let url= `payment-delete/${pNo}`;
	let method='DELETE';
	let contentType='application/json;charset=UTF-8';
	let sendData={};
	let async=true;
	Request.ajaxRequest(url,method,contentType,
						JSON.stringify(sendData),	//json으로 보낼 때 전부 string화 해 줘야 한다.
						function(resultJson){
							//code=1 성공 -> render , 아닐때 msg
							if(resultJson.code==1){
								$('.content-current').find("#"+pNo).parent().remove();
								//e.target.closest('#paymentD'+pNo).parent().remove();
							} else{
								alert(resultJson.msg);
							}
						},async);
	e.preventDefault();
});
/*
//2. 예약 상세보기
$(document).on('click',"button[name='paymentDetail']",function(e){
	let pNo=e.target.value;
	console.log(pNo);
		let url= 'payment-detail?pNo='+pNo;
	let method='GET';
	let contentType='application/json;charset=UTF-8';
	let sendData={};
	let async=true;
	Request.ajaxRequest(url,method,contentType,
						sendData,
						function(resultJson){
							//code=1 성공 -> render , 아닐때 msg
							alert('막');
							if(resultJson.code==1){
								window.location.href="tour-payment-confirmation";
							}else if(resultJson.code==2){
								window.location.href="ticket-payment-confirmation";
							}else{
								alert(resultJson.msg);
							}
						},async);
	e.preventDefault();
});
*/

/************************* admin *************************/

$(document).on('click', '#btn-user-admin', function(e) {
	Request.ajaxRequest('user-admin',
						'GET',
						'application/json;charset=UTF-8',
						{},
						function(response) {
							if(response.status == 1){
								View.render('#user-admin-template', response, '#tabs');
							} else {
								alert(response.message);
							}
						},
						true);
	e.preventDefault();
});


$(document).on('click', '.btn-admin-remove.btn_1.outline', function() {
    var userId = $(this).data('user-id');
	Swal.fire({
	  text: "정말 회원을 탈퇴시키겠습니까?",
	  icon: "warning",
	  showCancelButton: true,
	  confirmButtonColor: "#3085d6",
	  cancelButtonColor: "#d33",
	  confirmButtonText: "확인",
	  cancelButtonText: "취소"
	}).then((result) => {
	  if (result.isConfirmed) {
	    $.ajax({
	      url: "./user-admin/remove",
	      type: "POST",
	      data: { userId: userId },
	      success: function(response) {
	        if (response.status === 1) {
	          Swal.fire({
				  position: 'center',
				  icon: 'success',
				  text: '회원 탈퇴가 완료되었습니다.',
				  showConfirmButton: false,
				  timer: 1000
				})
				setTimeout(() => {
				Swal.close();
	          location.reload();
		    }, 1000);
	        } else {
	          Swal.fire("회원 탈퇴에 실패하였습니다.", "", "error");
	        }
	      },
	      error: function(xhr) {
	        Swal.fire("서버 오류가 발생했습니다.", "", "error");
	      }
	    });
	  }
});
});


/************************* login *************************/
 
const Toast = Swal.mixin({
  toast: true,
  position: 'bottom-right',
  iconColor: 'white',
  customClass: {
    popup: 'colored-toast',
  },
  showConfirmButton: false,
  timer: 1500,
  timerProgressBar: true
})



//회원 가입 폼
$(document).on('click','#btn-user-join',function() {
	location.href="user-write";
});
	
//로그인 액션
$(document).on('click','#btn-user-login',function(e) {
    if (document.f.userId.value == "") {
		Toast.fire({
		  icon: 'error',
		  title: '아이디를 입력하세요.'
		})
      document.f.userId.focus();
      return false;
    }
    if (document.f.password.value == "") {
		Toast.fire({
		  icon: 'error',
		  title: '비밀번호를 입력하세요.'
		})
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
		    const toast = Swal.fire({
		      position: 'center',
		      icon: 'success',
		      text: '로그인 성공! 이전 페이지로 이동합니다.',
		      showConfirmButton: false
		    });
		    setTimeout(() => {
		      toast.close();
		      window.location.replace(data.data);
		    }, 1000);
        } else if (data.status == 1) {
          View.render('#user-auth-template', {}, '#user-login');
        } else {
		Toast.fire({
		  icon: 'error',
		  title: data.message
		})      
        }
      },
      error: function(xhr, status, error) {
        console.error(error);
		Toast.fire({
		  icon: 'error',
		  title: '로그인에 실패했습니다.'
		})
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
		Toast.fire({
		  icon: 'error',
		  title: '이름을 입력하세요.'
		})
        document.i.name.focus();
        return false;
    }
    if (email == "") {
		Toast.fire({
		  icon: 'error',
		  title: '이메일을 입력하세요.'
		})
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
			    Swal.fire({
					icon: 'success',
					text: response.message
				})
            } else if (response.status == 2) {
			    Swal.fire({
					icon: 'error',
					text: response.message
				})
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
		Toast.fire({
		  icon: 'error',
		  title: '아이디를 입력하세요.'
		})
    document.p.name.focus();
    return false;
  }
  if (email === "") {
		Toast.fire({
		  icon: 'error',
		  title: '이메일을 입력하세요.'
		})
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
		    const toast = Swal.fire({
		      position: 'center',
		      icon: 'success',
		      text: '이메일로 임시 비밀번호가 발송되었습니다. 로그인 페이지로 이동합니다.',
		      showConfirmButton: false
		    });
		    setTimeout(() => {
		      toast.close();
		      window.location.replace('user-login');
		    }, 1000);
      } else {
		    Swal.fire({
				icon: 'error',
				text: response.message
			})
      }
    },
    error: function (xhr, status, error) {
      console.error(error);
		Toast.fire({
		  icon: 'error',
		  title: '오류가 발생했습니다.'
		})     
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
	 		    const toast = Swal.fire({
			      position: 'center',
			      icon: 'success',
			      text: '인증 성공! 로그인 페이지로 이동합니다.',
			      showConfirmButton: false
			    });
			    setTimeout(() => {
			      toast.close();
			      window.location.replace(response.data);
			    }, 1000);
            } else {
			Toast.fire({
			  icon: 'error',
			  title: '인증 코드가 일치하지 않습니다.'
			})
            }
        },
        error: function(xhr) {
		Toast.fire({
		  icon: 'error',
		  title: '서버 오류가 발생했습니다.'
		})
        }
    });
      e.preventDefault();
});


/************************* write *************************/

//아이디 중복 검사 후 true 반환
let isIdChecked = false;
//비밀번호 유효성 검사 후 true 반환
let isValidPassword = false;


//아이디 유효성 검사, 중복 체크
$(document).on('click','#btn-user-id-check',function(e) {
	const idValidate = /^[a-z][-_.a-z0-9]{5,11}$/g;
	const userId = $('#userId').val().trim();

	if (!idValidate.test(userId)) {
		Toast.fire({
		  icon: 'error',
		  title: '사용 불가능한 아이디 형식입니다.'
		})
		return $('#userId').val('');
	}
	if (userId === '') {
		Toast.fire({
		  icon: 'error',
		  title: '아이디를 입력하세요.'
		})
		return;
	}

		$.ajax({
			url: './idCheck',
			type: 'post',
    	    data: { userId: userId },
    	    success: function(cnt) {
				if (cnt == 0) {
					Swal.fire({
						icon: 'success',
						text: '사용 가능한 아이디입니다.'
					})
					isIdChecked = true;
				} else {
					Swal.fire({
						icon: 'error',
						text: '이미 사용중인 아이디입니다.'
					})
					$('#userId').val('');
				}
			},
			error: function() {
				Toast.fire({
				  icon: 'error',
				  title: '오류가 발생했습니다.'
				})
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
			isValidPassword = true;
		}
		e.preventDefault();	
	});
	
	$(password2).on('keyup', function(e) {
		
		if(password1.val() !== password2.val()) {
			passwordsInfo.removeClass().addClass('weakpass').html("비밀번호 확인이 일치하지 않습니다.");	
		}else{
			passwordsInfo.removeClass().addClass('goodpass').html("비밀번호 확인이 일치합니다.");	
			isValidPassword = true;
		}
		e.preventDefault();	
	});
	return isValidPassword;
};

//회원 가입
$(document).on('click','#btn-user-create',function(e) {
    	
	  var user = {};
	  user.userId = $("#userId").val();
	  user.password = $("#password1").val();
	  user.password2 = $("#password2").val();
	  user.name = $("#name").val();
	  user.nickname = $("#nickname").val();
	  user.phone = $("#phone").val();
	  user.email = $("#email").val();
	  user.birth = $("#birth").val();
	  user.address = $("#address").val();
	  user.gender = $("input[name=gender]:checked").val();
	  
	const termsService = document.getElementById("termsService");
	const termsPrivacy = document.getElementById("termsPrivacy");
		  
	if (!termsService.checked || !termsPrivacy.checked) {
		Toast.fire({
			icon: 'error',
			title: '이용 약관에 모두 동의해주세요.'
		})
		return false;
	}
	if (user.userId === "") {
		Toast.fire({
			icon: 'error',
			title: '아이디를 입력하세요.'
		})
	    $("#userId").focus();
	    return false;
	}
	if (!isIdChecked) {
		Toast.fire({
			icon: 'error',
			title: '아이디 중복 확인 버튼을 클릭해주세요.'
		})
	    return false;
	}
	if (user.password !== user.password2) {
		Toast.fire({
			icon: 'error',
			title: '비밀번호와 비밀번호 확인은 일치해야 합니다.'
		})
	    $("#password2").focus().select();
	    return false;
	}
	if (!isValidPassword) {
		return false;
	}
	if (user.name === "") {
		Toast.fire({
			icon: 'error',
			title: '이름을 입력하세요.'
		})
	    $("#name").focus();
	    return false;
	}
	if (user.nickname === "") {
		Toast.fire({
			icon: 'error',
			title: '닉네임을 입력하세요.'
		})
	    $("#nickname").focus();
	    return false;
	}
	if (user.phone === "") {
		Toast.fire({
			icon: 'error',
			title: '휴대폰 번호를 입력하세요.'
		})
	    $("#phone").focus();
		return false;
	}
	if (user.email === "") {
		Toast.fire({
			icon: 'error',
			title: '이메일 주소를 입력하세요.'
		})
	    $("#email").focus();
		return false;
	}
	if (user.birth === "") {
		Toast.fire({
			icon: 'error',
			title: '생년월일을 입력하세요.'
		})
	    $("#birth").focus();
		return false;
	}
	if (user.address === "") {
		Toast.fire({
			icon: 'error',
			title: '주소를 입력하세요.'
		})
	    $("#address").focus();
		return false;
	}
	if (user.gender === "") {
		Toast.fire({
			icon: 'error',
			title: '성별을 선택하세요.'
		})
	    $("input[name=gender]").focus();
		return false;
	}
	$.ajax({
	    type: 'POST',
		url: './user-write-action',
		data: JSON.stringify(user),
		dataType: "json",
	    contentType: "application/json;charset=UTF-8",
	    success: function (data) {
	        if (data.status == 0) {
	          Swal.fire({
				  position: 'center',
				  icon: 'success',
				  text: data.message,
				  showConfirmButton: false,
				  timer: 1500
				})
				setTimeout(() => {
					Swal.close();
		            window.location.href = "./index";
			    }, 1500);
	        } else {
				Swal.fire({
					icon: 'error',
					text: data.message
				})
	        }
	    },
	    error: function (xhr, status, error) {
	        console.error(error);
			Swal.fire({
				icon: 'error',
				text: "회원가입에 실패했습니다."
			})
	    }
	}); 
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
	
	if (document.getElementsByName("password")[0].value == "") {
		Toast.fire({
		  icon: 'error',
		  title: '비밀번호를 입력하세요.'
		})
      document.getElementsByName("password")[0].focus();
      return false;
    }
    
    if (document.getElementsByName("password2")[0].value == "") {
		Toast.fire({
		  icon: 'error',
		  title: '비밀번호 확인을 입력하세요.'
		})
      document.getElementsByName("password2")[0].focus();
      return false;
    }
	  
	if (document.getElementsByName("password")[0].value !== document.getElementsByName("password2")[0].value) {
	   Toast.fire({
		  icon: 'error',
		  title: '비밀번호와 비밀번호 확인이 일치하지 않습니다.'
	  })
	    return;
	}
	
	let url = 'user-modify-form-action';
	let method = 'PUT';
	let formData = new FormData();
	let alcohol = $('input[name="aOptions"]:checked').val();
	let smoking = $('input[name="sOptions"]:checked').val();
	
	formData.append('userId', $('#userId').val());
	formData.append('password', $('#password3').val());
	formData.append('nickname', $('#nickname').val());
	formData.append('phone', $('#phone').val());
	formData.append('email', $('#email').val());
	formData.append('birth', $('#birth').val());
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


//프로필 수정 취소
$(document).on('click','#btn-user-modify-cancle',function() {
	location.href="user-view";
});

//첨부파일에 이름 나오게 
$("#file").on('change',function(){
  var fileName = $("#file").val();
  $(".upload-name").val(fileName);
});


