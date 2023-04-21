import * as View from "./view.js";
import * as Request from "./request.js";

/************ user-login *************/

	
//이메일 미인증 상태면 인증 폼 호출
/*
$(document).ready(function() {
  // user-auth-template 템플릿을 렌더링하는 함수
  function renderUserAuthTemplate() {
    let template = $('#user-auth-template').html();
    let renderTemplate = Handlebars.compile(template);
    $('#login').html(renderTemplate());
  }

  //로그인 버튼을 클릭하면 authUser.getMailAuth() != 1 일 때만 user-auth-template을 렌더링
  $('#login_btn').click(function(e) {
    e.preventDefault();
    
      // 바로 로그인 실행되게 수정
      $.ajax({
        type: 'POST',
        url: 'user-login',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
          userId: $('#user_id').val(),
          password: $('#password').val(),
        }),
        success: function(data) {
			if (data.authUser != 1) {
			console.log(data.authUser);
		      renderUserAuthTemplate();
		      /*
	      }else{
			
		}
		      
          if (data.status == 0) {
            window.location.href = data.data;
          } else {
            alert(data.message);
          }
        },
        error: function(xhr, status, error) {
          alert(error);
        },
      });
    }
  );
});
*/
/*
$(document).ready(function() {
  // user-auth-template 템플릿을 렌더링하는 함수
  function renderUserAuthTemplate() {
    let template = $('#user-auth-template').html();
    let renderTemplate = Handlebars.compile(template);
    $('#login').html(renderTemplate());
  }

  //로그인 버튼을 클릭하면 authUser.getMailAuth() != 1 일 때만 user-auth-template을 렌더링
  $('#login_btn').click(function(e) {
    e.preventDefault();
    
      // 바로 로그인 실행되게 수정
      $.ajax({
        type: 'POST',
        url: 'user-login',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
          userId: $('#user_id').val(),
          password: $('#password').val(),
        }),
        success: function(data) {
			if (data.status === 1) {
			  console.log(data.message);
			  renderUserAuthTemplate();
			} else {
			  console.log(data.message);
			}
        },
        error: function(xhr, status, error) {
          alert(error);
        },
      });
    }
  );
});
*/

$(document).ready(function() {
  // user-auth-template 템플릿을 렌더링하는 함수
  function renderUserAuthTemplate() {
    let template = $('#user-auth-template').html();
    let renderTemplate = Handlebars.compile(template);
    $('#login').html(renderTemplate());
  }

  // 메뉴의 "로그인" 버튼이 클릭되면 user-auth-template을 렌더링합니다.
  $('#login_btn').click(function(e) {
    e.preventDefault();
    renderUserAuthTemplate();
  });
});

//아이디, 비밀번호 찾기 폼
$('#menu-user-find').click(function(e){
	View.render('#user-find-template', {}, '#user-login');
	e.preventDefault();
});

// 프로필 수정 폼 
$(document).on('click', '#btn-user-modify-form', function(e) {
	console.log("click!! >> " + e.target)
	Request.ajaxRequest('user-modify-form',
						'GET',
						'application/json;charset=UTF-8',
						{},
						function(resultJson) {
							console.log(">>>>>>>>>>>>>>>>>>>>>>>>>> ")
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
	let form = $('user-modify-form');
	console.log(form);
	let url = 'user-modify-form-action';
	let method = 'PUT';
	let formData = new FormData();
	
	formData.append('userId', $('#userId').val());
	formData.append('password', $('#password1').val());
	formData.append('nickname', $('#nickname').val());
	formData.append('phone', $('#phone').val());
	formData.append('email', $('#email').val());
	formData.append('brith', $('#brith').val());
	formData.append('address', $('#address').val());
	formData.append('alcohol', $('#alcohol').val());
	formData.append('smoking', $('#smoking').val());
	formData.append('introduce', $('#introduce').val());
	
	let async = true;
	console.log(formData);
		
	$.ajax({
	    method : method,
	    url : url, 
	    data : formData,
	    processData: false,
	    contentType: false,
	    success : function(resultJson){
		
		console.log(">>>>>>>");
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



