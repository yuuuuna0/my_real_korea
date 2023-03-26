package com.itwill.my_real_korea.dao;

import java.util.List;

import com.itwill.my_real_korea.dto.ChatRoom;

public interface ChatMsgDao {

		// 채팅방 목록 보기
		public List<ChatRoom> selectAll(String userId);
		
		// 채팅방 목록 선택 기능
		public ChatRoom selectByRoomNo(int roomNo);
		
		// from_id, to_id로 채팅방 찾기
		public ChatRoom selectById(String fromId, String toId);
		
		// 채팅 생성 중복 체크
		public List<ChatRoom> selectExist(String fromId, String toId);
		
		// 채팅방 생성
		//public int insertChatRoom(String roomName, String fromId, String toId);
		public int insertChatRoom(ChatRoom chatRoom);
		
		// 채팅방 삭제
		public int deleteChatRoom(int roomNo);
		
		// 1개의 채팅방 안 읽은 메세지 수
		public int countNotReadInChatRoom(int roomNo, String userId);
		
		// from_id로 채팅중인 사람들 
		
		
		
	
}
