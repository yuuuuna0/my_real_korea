package com.itwill.my_real_korea.service;

import java.util.List;

import com.itwill.my_real_korea.dto.ChatMsg;
import com.itwill.my_real_korea.dto.ChatRoom;

public interface ChatService {

	/*
	 * chatRoom
	 */
	
	// 채팅방 목록 보기 ㅇ
	public List<ChatRoom> selectAll(String userId);
	
	// 채팅방 목록 선택 기능 ㅇ
	public ChatRoom selectCheckByRoomNo(int roomNo);
	
	// from_id, to_id로 채팅방 찾기
	//public ChatRoom selectById(String fromId, String toId);
	public int chatRoomExistById(String fromId, String toId);
	
	// 채팅 생성 중복 체크
	boolean duplicateCheck(String fromId, String toId);
	
	public List<ChatRoom> selectExist(String fromId, String toId);
	
	// 채팅방 생성 ㅇ
	public int insertChatRoom(ChatRoom chatRoom);
	
	// 채팅방 삭제 ㅇ
	public int deleteChatRoom(int roomNo);
	
	// 1개의 채팅방 안 읽은 메세지 수
	public int countNotReadInChatRoom(int roomNo, String userId);	
	
	/*
	 * chatMsg
	 */
	// 채팅방 1개의 전체 대화보기 ㅇ
	public List<ChatMsg> selectByRoomNo(int roomNo);
	
	// 채팅 메세지 1개 보기 ㅇ
	public ChatMsg selectByMsgNo(int msgNo);
	
	// 채팅방 1개의 읽지 않은 메세지 보기
	public ChatMsg selectNotReadMsg(int roomNo, String userId);
	
	// 채팅방 1개의 읽지 않은 메세지 수 ㅇ
	public int countNotReadMsg(int roomNo, String userId);
	
	// 읽지 않은 메세지 전체 보기
	public List<ChatMsg> selectAllNotReadMsg(String userId);
	
	// 읽지 않은 메세지 총 개수 ㅇ
	public int countAllNotReadMsg(String userId);
	
	// 메세지 읽음으로 변경 ㅇ
	public int updateReadMsg(int roomNo, String userId);
	
	// 채팅 메세지 1개 삭제 ㅇ
	public int deleteChatMsg(int msgNo);
	
	// 채팅 메세지 삭제 시 메세지 대체 ㅇ
	public int updateDeletedMsg(int msgNo);
	
	// 채팅 생성 ㅇ
	public int insertChatMsg(ChatMsg chatMsg);

	
}
