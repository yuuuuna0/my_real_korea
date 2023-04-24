
import * as View from "./view.js";
import * as Request from "./request.js";
 
/*
 */
let sock;
let myId = $('#myId').val();
let roomName = document.getElementById('roomName').textContent;
console.log(myId);
console.log(roomName);

const serializedList = $('#jsonMyChatRoomNameList').val();
const myChatRoomNameList = JSON.parse(serializedList);
console.log(myChatRoomNameList);

let receiverId;
let preOnlineList;
let masterStatusContent;  
let preMasterStatus;
let masterStatus;


/*****************소켓 연결/해제*******************/
function onClose(evt) {
        	 console.log("close event : " + evt);
         }
function onOpen(evt) {
        	 console.log("open event : " + evt);
         }
         
 
    
     

/**********페이지 로딩 시 - 소켓연결, DB내용 가져오기*********/
$(document).ready(function(){
	sock = new WebSocket("ws://localhost:80/final-project-team2-my-real-korea/ws/chat");
	sock.onmessage = onMessage;
	sock.onopen = onOpen;
	sock.onClose = onClose;
	
	// DB에 저장된 대화내용 가져오기
	let receiverId = document.getElementById('receiverId').value;
	getChatFromDB(myId,receiverId);
	scrollDown();
});

/**********채팅메세지 보내기(버튼 클릭or엔터)*********/
function sendMessage() {
	let message = $("#msg").val();
	let msg = {
    		 "receiverId" : receiverId,
    		 "message" : message
	        	 }
	sock.send(JSON.stringify(msg));
	$('#msg').val("");
}

$("#msg").keyup(e => {
	if (e.keyCode == 13) {
		sendMessage();
	}
});

$(document).on('click','#button-send', function(e){
	sendMessage();

});

/***************채팅방 나가기*******************/
$(document).on('click','#disconn', function(e) {
	onClose();
	sock.onClose;
	console.log('채팅방 나가기');
	window.close();
});
/************ onMessage *************/
function onMessage(msg) {
	let data = JSON.parse(msg.data);
	let onlineList = data.onlineList;
	let senderId = data.senderId;
	let receiverId = data.receiverId;
	let message = data.message;
	let time = data.time;
	let newOne = data.newOne;
	let outOne = data.outOne;
	console.log('msg.data >>> ', msg.data);
	console.log('onlineList >>>> ', onlineList);
	console.log('senderId >>> ', senderId)
	console.log('receiverId >>> ', receiverId)
	console.log('message >>> ', message)
	console.log('time >>> ', time)
	console.log('newOne >>> ', newOne);
	console.log('outOne >>> ', outOne);

	// 새로운 유저 접속했을 때 senderId가 포함된 roomName 가진 채팅방 목록 가져오기 - myChatRoomNameList
	/*
	if (newOne != null) {
		console.log("새로운 접속자 있음");
		getOnlineList(myChatRoomNameList);
	}
	*/
	
	// 메세지 보내기
	insertMessage(senderId, receiverId, time, message);
	// DB에 저장
	saveChatDB(senderId, receiverId, message, time);
	// scroll down
	scrollDown();
}

/************ 메세지 보내기 *************/
function insertMessage(senderId, receiverId,  time, message) {
	console.log('insertMessage[myId] : '+myId);
	console.log('insertMessage[senderId] : '+senderId);
	console.log('insertMessage[receiverId] : '+receiverId);
	let chatContent = document.querySelector("#chat-content");
	if (senderId == myId) {
		// 보내는 사람이 나 일 때(오른쪽 메세지)
		let li = document.createElement('li');
		li.classList.add('message-li', 'clearfix', 'float-right');
		let infoDiv = document.createElement('div');
		infoDiv.classList.add('message-data');
		li.appendChild(infoDiv);
		let timeSpan = document.createElement('span');
		timeSpan.classList.add('message-data-time');
		timeSpan.textContent = time;
		infoDiv.appendChild(timeSpan);
		let msgDiv = document.createElement('div');
		msgDiv.classList.add('message', 'my-message');
		msgDiv.textContent = message;
		li.appendChild(msgDiv);

		chatContent.appendChild(li);
	} else {
		// 보내는 사람 받는 사람 다를 때(왼쪽 메세지)
		let li = document.createElement('li');
		li.classList.add('message-li', 'clearfix');
		let infoDiv = document.createElement('div');
		infoDiv.classList.add('message-data');
		li.appendChild(infoDiv);
		let timeSpan = document.createElement('span');
		timeSpan.classList.add('message-data-time');
		timeSpan.textContent = time;
		infoDiv.appendChild(timeSpan);
		let msgDiv = document.createElement('div');
		msgDiv.classList.add('message', 'other-message');
		msgDiv.textContent = message;
		li.appendChild(msgDiv);

		chatContent.appendChild(li);
	}
	
}

/************ DB에서 메세지 가져오기 *************/
function getMessage(senderId, receiverId, userId,  time, message) {
	console.log('insertMessage[myId] : '+myId);
	console.log('insertMessage[senderId] : '+senderId);
	console.log('insertMessage[userId] : '+userId);
	let chatContent = document.querySelector("#chat-content");
	if (senderId == userId) {
		// 보낸사람과 현재 로그인한 유저 같을 때(오른쪽 메세지)
		let li = document.createElement('li');
		li.classList.add('message-li', 'clearfix', 'float-right');
		let infoDiv = document.createElement('div');
		infoDiv.classList.add('message-data');
		li.appendChild(infoDiv);
		let timeSpan = document.createElement('span');
		timeSpan.classList.add('message-data-time');
		timeSpan.textContent = time;
		infoDiv.appendChild(timeSpan);
		let msgDiv = document.createElement('div');
		msgDiv.classList.add('message', 'my-message');
		msgDiv.textContent = message;
		li.appendChild(msgDiv);

		chatContent.appendChild(li);
	} else {
		// 보내는 사람 받는 사람 다를 때(왼쪽 메세지)
		let li = document.createElement('li');
		li.classList.add('message-li', 'clearfix');
		let infoDiv = document.createElement('div');
		infoDiv.classList.add('message-data');
		li.appendChild(infoDiv);
		let timeSpan = document.createElement('span');
		timeSpan.classList.add('message-data-time');
		timeSpan.textContent = time;
		infoDiv.appendChild(timeSpan);
		let msgDiv = document.createElement('div');
		msgDiv.classList.add('message', 'other-message');
		msgDiv.textContent = message;
		li.appendChild(msgDiv);

		chatContent.appendChild(li);
	}
}

/************ 채팅 내용 DB에 저장 *************/
function saveChatDB(senderId, receiverId, message, time){
	let jsonData = {};
	document.querySelectorAll('.message-li').forEach(item => {
		let type = item.querySelector('.message').classList[1];
		let time = item.querySelector('.message-data > .message-data-time').textContent;
        let message = item.querySelector('.message').textContent;
		jsonData = {
			"myId":myId,
			"senderId": senderId,
			"receiverId": receiverId,
			"message": message,
			"roomName": roomName,
			"time": time
		}
	})
	let url = 'save-chat';
	let method = 'POST';
	let contentType = 'application/json;charset=UTF-8';
	let sendData = JSON.stringify(jsonData); // 메세지 전송데이터
	console.log('[savechat]sendData' + sendData);
	let async = true;

	Request.ajaxRequest(url, method, contentType,
						sendData,
						function(resultJson) {
							console.log('>>>>>>>>>>saveChatDB 접근');
							if (resultJson.code == 1) {
								console.log('saveChatDB 성공');
							} else {
								console.log(resultJson.msg);
							};
						}, async);
};

/************ 채팅 내용 가져오기(DB연결) *************/
function getChatFromDB(myId,receiverId){
	let url='chat-detail-rest';
	let method='POST';
	let contentType='application/json;charset=UTF-8';
	let sendData = {
		"roomName":roomName,
		"senderId":myId,
		"receiverId":receiverId
	};
	let async=true;
	
	Request.ajaxRequest(url, method, contentType, 
						JSON.stringify(sendData),
						function(resultJson){
							console.log(">>>>>>>>>getChatFromDB 접근");
							if(resultJson.code == 1){
								let roomName = resultJson.roomName;
								let senderId = resultJson.senderId;
								let receiverId = resultJson.receiverId;
								let chatList = resultJson.data;
								
								for (const item of chatList) {
									getMessage(senderId, receiverId, item.userId, item.msgSendTime, item.msgContent);
								}
								console.log("getChatFromDB senderId :" + senderId);
							} else {
								console.log(resultJson.msg);
							};
		}, async);
};


/************ 스크롤 내릴 때 *************/
function scrollDown() {
	var chatContent = document.querySelector("#chat-content");
	chatContent.scrollTop = chatContent.scrollHeight;
};

    
/*
1. 채팅방 목록(로그인한 아이디(senderId)가 roomName 에 있는 방들만)
2. 채팅방 클릭 시 해당 채팅방으로 이동, DB내용 가져오기
3. 로그인 한 유저가 메세지 아이콘 클릭 시 본인의 채팅방 목록과 채팅창 보이게
*/

/************ 채팅방 목록의 채팅방 클릭 *************/
function activeToggle(element) {
	if (!element.classList.contains('active')) {
		element.classList.add('active');
	} else {
		element.classList.remove('active');
	};
	var preReceiverId = receiverId;
	receiverId = element.querySelector('.about > .name').textContent;
	console.log('<<<< toggleAction >>>>>')
	console.log('receiverId >>> ', receiverId);
	console.log('preReceiverId >>> ', preReceiverId);

	if (receiverId != preReceiverId && preReceiverId != null) {
		document.getElementById(preReceiverId).classList.remove('active');
	}
	setChatHistory(preReceiverId);
	document.getElementById('chat-content').innerHTML = "";
	getChatHistory(receiverId);
	divideChatSection(receiverId);
	
	if (document.getElementById(receiverId).querySelector('.circle') != null) {
		document.getElementById(receiverId).querySelector('.circle > .staging-count').textContent = "";
		document.getElementById(receiverId).querySelector('.circle').classList.add('d-none');
	}
}

/************ 채팅방 목록의 채팅방 클릭 ************/
$(document).on('click','#chat-room-list', function(e) {
	// DB에 저장된 대화내용 가져오기
	let chatRoomName = $(this).find('#master').text();
	console.log('채팅방클릭-chatRoomName:'+chatRoomName);
	let receiverIdFromRoom = chatRoomName.substr(chatRoomName.indexOf("&") + 1);
	console.log('채팅방클릭-receiverIdFromRoom:'+receiverIdFromRoom);
	window.location.href='chat?receiverId='+receiverIdFromRoom;
	getChatFromDB(myId,receiverId);
	scrollDown();
});


/************ 모든 채팅 사용자들 채팅방 목록에 넣기 ***********
function getOnlineList(myChatRoomNameList) {
	var onlineUser = document.querySelector("#online-user");
	onlineUser.innerHTML = "";
	for (var chatRoomName in myChatRoomNameList) {
		insertOnlineList(myChatRoomNameList[chatRoomName]);
	}
}
**/
/************ 채팅방 목록 가져오기 ************
function insertOnlineList(user) {

	if (document.getElementById(user) == null) {
		var onlineUser = document.querySelector("#online-user");

		var li = document.createElement('li');
		li.classList.add('clearfix');
		//li.setAttribute('onclick', 'activeToggle(this)');
		li.setAttribute('id', user);

		var aboutDiv = document.createElement('div');
		aboutDiv.classList.add('about');
		var name = document.createElement('div');
		name.classList.add('name');
		name.textContent = user;
		aboutDiv.appendChild(name);

		var statusDiv = document.createElement('div');
		statusDiv.classList.add('status');
		var icon = document.createElement('i');
		icon.setAttribute('id', 'master-status-icon');
		icon.classList.add('fa', 'fa-circle', 'online');
		var span = document.createElement('span');
		span.setAttribute('id', 'master-status-content');
		span.textContent = '채팅중';
		statusDiv.appendChild(icon);
		statusDiv.appendChild(span);

		aboutDiv.appendChild(statusDiv);

		li.appendChild(aboutDiv);

		var alertDiv = document.createElement('div');
		alertDiv.classList.add('circle', 'd-flex', 'align-items-center', 'justify-content-center', 'd-none');
		let aspan = document.createElement('span');
		aspan.classList.add('staging-count');
		alertDiv.appendChild(aspan);
		li.appendChild(alertDiv);

		onlineUser.appendChild(li);
	}
};
*/


/**************채팅 아이디 가져오기****************/

function getUserId(){
	let url = 'get-chat-id';
	let method = 'GET';
	let contentType = 'application/json;charset=UTF-8';
	let sendData = {};
	let async = true;
	let userId = null;
	Request.ajaxRequest(url, method, contentType, 
						sendData,
						function(resultJson){
							if(resultJson.code == 1){
								userId = resultJson.userId;
								console.log("채팅아이디 :" + userId);
							} else {
								alert(resultJson.msg);
							};
						}, async);
	return userId;
}

/**************안읽은 채팅 수 가져오기***************/
function getChatNum(userId) {
	let roomNo = '1';
	let url = `count-not-read-chat?userId=${userId}&roomNo=${roomNo}`;
	let method = 'GET';
	let contentType = 'application/json;charset=UTF-8';
	let sendData = {};
	let async = true;
	Request.ajaxRequest(url, method, contentType,
						sendData,
						function(resultJson)  {
						//code 1 , 안읽은 채팅이 있을 때
						if (resultJson.code == 1 && resultJson.data != 0) {
							console.log('안읽은채팅 있음');
						// 안읽은 채팅이 0 일 때	
						} else if(resultJson.code == 1 && resultJson.data == 0) {
							console.log('안읽은채팅 없음');
						} else {
							alert(resultJson.msg);
						};
						}, async);
}






