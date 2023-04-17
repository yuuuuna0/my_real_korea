import * as View from "./view.js";
import * as Request from "./request.js";

/************ user-login *************/

	
//이메일 미인증 상태면 인증 폼 호출
$(document).ready(function() {
  //user-auth-template 템플릿을 렌더링
  function renderUserAuthTemplate() {
    let template = $('#user-auth-template').html();
    let renderTemplate = Handlebars.compile(template);
    $('#login').html(renderTemplate());
  }

  //로그인 버튼을 클릭하면 authUser.getMailAuth() != 1 일 때만 user-auth-template을 렌더링
  $('#login_btn').click(function(e) {
    e.preventDefault();
    if (authUser.getMailAuth() != 1) {
      renderUserAuthTemplate();
    } else {
      // 바로 로그인 실행되게 수정
      $.ajax({
        type: 'POST',
        url: '/user-login',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
          userId: $('#user_id').val(),
          password: $('#password').val(),
        }),
        success: function(data) {
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
  });
});


//아이디, 비밀번호 찾기 폼
$('#menu-user-find').click(function(e){
	View.render('#user-find-template', {}, '#user-login');
	e.preventDefault();
});







