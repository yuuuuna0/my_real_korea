package com.itwill.my_real_korea.service.chat;

import java.util.List;

import com.itwill.my_real_korea.dto.chat.ChatMsg;
import com.itwill.my_real_korea.dto.chat.ChatRoom;

public interface ChatService {

	/*
	 * chatRoom
	 */
	
	// 채팅방 목록 보기 
	public List<ChatRoom> selectAll(String userId);
	
	// 채팅방 목록 선택 기능 
	public ChatRoom selectCheckByRoomNo(int roomNo);
	
	// from_id, to_id로 채팅방 번호 찾기
	public int chatRoomNoSearchById(String fromId, String toId);
	
	// 채팅 생성 중복 체크
	boolean duplicateCheck(String fromId, String toId);
	
	// 채팅방 생성 
	public int insertChatRoom(ChatRoom chatRoom);
	
	// 채팅방 삭제 
	public int deleteChatRoom(int roomNo);
	
	// 1개의 채팅방 안 읽은 메세지 수
	public int countNotReadInChatRoom(int roomNo, String userId);	
	
	/*
	 * chatMsg
	 */
	// 채팅방 1개의 전체 대화보기 
	public List<ChatMsg> selectByRoomNo(int roomNo);
	
	// 채팅 메세지 1개 보기 
	public ChatMsg selectByMsgNo(int msgNo);
	
	// 채팅방 1개의 읽지 않은 메세지 보기
	public List<ChatMsg> selectNotReadMsg(int roomNo, String userId);
	
	// 채팅방 1개의 읽지 않은 메세지 중 가장 최근 메세지 1개 보기
	public ChatMsg selectLastNotReadMsg(int roomNo, String userId);
	
	// 채팅방 1개의 읽지 않은 메세지 수 
	public int countNotReadMsg(int roomNo, String userId);
	
	// 읽지 않은 메세지 전체 보기
	public List<ChatMsg> selectAllNotReadMsg(String userId);
	
	// 읽지 않은 메세지 총 개수 
	public int countAllNotReadMsg(String userId);
	
	// 메세지 읽음으로 변경 
	public int updateReadMsg(int roomNo, String userId);
	
	// 채팅 메세지 1개 삭제 
	public int deleteChatMsg(int msgNo);
	
	// 채팅 메세지 삭제 시 메세지 대체 
	public int updateDeletedMsg(int msgNo);
	
	// 채팅 생성 
	public int insertChatMsg(ChatMsg chatMsg);

	
}
