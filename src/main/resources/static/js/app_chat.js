import * as View from "./view.js";
import * as Request from "./request.js";
 
/*
 */
let sock;
//let userId = getUserId();
var jsonData = {
			code:null,
			url:null,
			msg:null,
			roomNo:null,
			userId:null,
			receiverId:null, // 상대 아이디 
			data:null //chat_contents 
};
/*
const socket = new WebSocket("ws/chat");
socket.onopen = function() {
	console.log("WebSocket 연결 성공");
};
socket.onmessage = function(event) {
	console.log("서버로부터 메시지 수신: " + event.data);
};
socket.onclose = function(event) {
	console.log("WebSocket 연결 종료");
};
*/
 
/***************채팅 시작*******************/

$(document).on('click', '#chat-start-btn', function(e) {
	sock = new SockJS("ws/chat");
	sock.onopen = function() {
		alert('연결에 성공하였습니다.');

		sock.onmessage = (data => {
			const newChatBox = $('<div class="message other-message float-right"></div>'); // 새로운 chatBox 생성
			$("<div>" + data.data + "</div>").prependTo(newChatBox); // 데이터를 새로 생성한 chatBox 안에 추가
			$('#chatContainer').prepend(newChatBox); // chatContainer의 맨 앞에 새로 생성한 chat-box 요소를 추가
		});
		$('#chatConnect').hide();
	}
	sock.onerror = function(e) {
		alert('연결에 실패하였습니다.');
	}
	sock.onclose = function() {
		alert('연결을 종료합니다.');
	};
});

/**********채팅메세지 보내기(버튼 클릭or엔터)*********/
function sendMessage() {
	sock.send($("#msg").val());
	$('#msg').val("");
}

$("#msg").keyup(e => {
	if (e.keyCode == 13) {
		sendMessage();
	}
});

$("#button-send").click(() => {
	sendMessage();
});

/**************채팅 아이디 가져오기**************


function getUserId(){
	let url = 'get-chat-id';
	let method = 'POST';
	let contentType = 'application/json;charset=UTF-8';
	let sendData = {};
	let async = true;
	Request.ajaxRequest(url, method, contentType, 
						sendData,
						function(resultJson){
							//code 1 일때 session 에서 얻은 chatId 가져오기
							if(resultJson.code == 1){
								userId = resultJson.userId;
								console.log("채팅아이디 :" + userId);
							} else {
								alert(resultJson.msg);
							};
						}, async);
	return userId;
}
**/
/**************안읽은 채팅 수 가져오기***************
function getChatNum() {
	let url = `count-not-read-chat?userId=${userId}&roomNo=${roomNo}`;
	let method = 'POST';
	let contentType = 'application/json;charset=UTF-8';
	let sendData = {};
	let async = true;
	let userId = userId;
	let roomNo = $().val;
	Request.ajaxRequest(url, method, contentType,
						sendData,
						function(resultJson)  {
						//code 1 , 안읽은 채팅이 있을 때
						if (resultJson.code == 1 && resultJson.data != 0) {
							
						// 안읽은 채팅이 0 일 때	
						} else if(resultJson.code == 1 && resultJson.data == 0) {
							
						} else {
							alert(resultJson.msg);
						};
						}, async);
}

*/




