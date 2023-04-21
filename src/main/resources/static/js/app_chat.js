import * as View from "./view.js";
import * as Request from "./request.js";
 
/*
 */
let sock;
let myId = document.getElementById('myId').textContent;
let receiverId;
let preOnlineList;
let masterStatusContent;  
let preMasterStatus;
let masterStatus;
//let userId = getUserId();
let jsonData = {
			code:null,
			url:null,
			msg:null,
			roomNo:null,
			userId:null,
			receiverId:null, // 상대 아이디 
			data:null //chat_contents 
};
if (myId != 'master') {
	receiverId = 'master';
}
 
/***************채팅 시작*******************/

$(document).on('click', '#chat-start-btn', function(e) {
	sock = new WebSocket("ws://localhost:80/final-project-team2-my-real-korea/ws/chat");
	sock.onmessage = onMessage;
	
	sock.onopen = function() {
		alert('연결에 성공하였습니다.');

		// 메세지 보내기
		/*
		sock.onmessage = (data => {
			const newChatBox = $('<div class="message other-message float-right"></div>'); // 새로운 chatBox 생성
			$("<div>" + data.data + "</div>").prependTo(newChatBox); // 데이터를 새로 생성한 chatBox 안에 추가
			$('#chatContainer').prepend(newChatBox); // chatContainer의 맨 앞에 새로 생성한 chat-box 요소를 추가
		});
		*/
		$('#chatConnect').hide();
	}
	

	sock.onerror = function() {
		console.log('연결에 실패하였습니다.');
	}
	sock.onclose = function() {
		console.log('연결을 종료합니다.');
	};
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

$(document).on('click','#disconn', function(e){
	window.location.href = 'index'; 
});

/************ onMessage *************/
function onMessage(msg) {
	let data = JSON.parse(msg.data);
	let onlineList = data.onlineList;
	let senderId = data.senderId;
	let message = data.message;
	let time = data.time;
	let newOne = data.newOne;
	let outOne = data.outOne;
	console.log('msg.data >>> ', msg.data);
	console.log('onlineList >>>> ', onlineList);
	console.log('senderId >>> ', senderId)
	// let receiverId = data.receiverId;
	// console.log('receiverId >>> ', receiverId)
	console.log('message >>> ', message)
	console.log('time >>> ', time)
	console.log('newOne >>> ', newOne);
	console.log('outOne >>> ', outOne);

	// when user login
	// first login master -> get all onlined user list
	if (newOne != null) {
		console.log("new One is not null");
		if (myId == 'master' && newOne == "master") {
			getOnlineList(onlineList);
		} else if (myId == "master" && newOne != "master") {
			console.log("new one login >>>> ", newOne);
			insertOnlineList(newOne);
		}
	}
	// when user disconnect
	if (outOne != null && myId == 'master') {
		console.log("user disconnect >>> ", outOne);
		deleteOnlieList(outOne);
	}

	// save or show message
	if (myId == 'master' && senderId != 'master' && receiverId != senderId) {
		addStagingMessage(senderId, time, message);
	} else {
		// 메세지 보내기
		insertMessage(senderId, time, message);
	}
	// scroll down
	scrollDown();
}

/************ 채팅 보내기 *************/
function insertMessage(senderId, time, message) {
	console.log('insertMessage'+myId);
	console.log('insertMessage'+senderId);
	let chatContent = document.querySelector("#chat-content");
	if (senderId == myId) {
		// 보내는 사람이 나 일 때
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
		// 보내는 사람이 내가 아닐 때
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

/************ staging 메세지 저장 *************/
function addStagingMessage(senderId, time, message) {

	var container = [];
	var data = {
		"time": time,
		"message": message,
		"senderId": senderId
	}
	console.log('staging message data >>> ', data)
	if (sessionStorage.getItem(senderId) != null) {
		container = JSON.parse(sessionStorage.getItem(senderId));
		console.log('stagine message container >>> ', container);
		container.push(data);
	} else {
		container.push(data);
	}
	sessionStorage.setItem(senderId, JSON.stringify(container));

	if (document.getElementById(senderId) != null) {
		var circle = document.getElementById(senderId).querySelector('.circle');
		var count = document.getElementById(senderId).querySelector('.circle > .staging-count');
		var n = count.textContent;
		if (n == "") {
			n = 0
		}
		n++;
		circle.classList.remove('d-none');
		count.textContent = n;
	}
}

/************ insert division of receiver *************/
function divideChatSection(receiverId) {
	var div = document.createElement('div');
	div.classList.add('clearfix');
	var str = receiverId + '님 과의 대화 시작 ';
	var hr = document.createElement('hr');

	div.textContent = str;
	div.appendChild(hr);
	var chatContent = document.querySelector("#chat-content");
	chatContent.appendChild(div);

	scrollDown();
};

/************ 채팅 내용 저장 *************/
function setChatHistory(name) {
	var value = [];
	document.querySelectorAll('.message-li').forEach(item => {

		var time = item.querySelector('.message-data > .message-data-time').textContent;
		var message = item.querySelector('.message').textContent;
		var senderId;
		var type = item.querySelector('.message').classList[1];
		if (type == 'my-message') {
			senderId = myId;
		} else {
			senderId = name;
		}

		data = {
			"time": time,
			"message": message,
			"senderId": senderId
		}
		value.push(data);

	})
	//sessionStorage 말고 DB 에 저장해야됨!~!~!!
	sessionStorage.setItem(name, JSON.stringify(value));
};

/************ 채팅 내용 가져오기 *************/
function getChatHistory(name) {
	//sessionStorage 말고 DB 에서 가져와야됨!~!~!!
	var data = JSON.parse(sessionStorage.getItem(name));

	if (data != null) {
		data.forEach(item => {
			var time = item.time;
			var message = item.message;
			var senderId = item.senderId;

			insertMessage(senderId, time, message);
		})
	}
};

/************ 스크롤 내릴 때 *************/
function scrollDown() {
	var chatContent = document.querySelector("#chat-content");
	chatContent.scrollTop = chatContent.scrollHeight;
};

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






