import * as View from "./view.js";
import * as Request from "./request.js";

/************ user-login *************/

	
//이메일 미인증 상태면 인증 폼 호출
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







