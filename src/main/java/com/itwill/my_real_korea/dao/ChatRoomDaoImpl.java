package com.itwill.my_real_korea.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.ChatRoom;
import com.itwill.my_real_korea.mapper.ChatMsgMapper;
import com.itwill.my_real_korea.mapper.ChatRoomMapper;

@Repository
public class ChatRoomDaoImpl implements ChatRoomDao{

	@Autowired
	private ChatRoomMapper chatRoomMapper;
	
	public ChatRoomDaoImpl() {
		System.out.println("ChatRoomDaoImpl 기본생성자 호출");
	}
	public ChatRoomMapper getChatRoomMapper() {
		return chatRoomMapper;
	}
	public void setChatRoomMapper(ChatRoomMapper chatRoomMapper) {
		System.out.println(">>> ChatRoomDaoImpl():setChatRoomMapper()호출");
		this.chatRoomMapper = chatRoomMapper;
	}
	
	@Override
	public List<ChatRoom> selectAll(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChatRoom selectByRoomNo(int roomNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChatRoom selectById(String fromId, String toId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChatRoom> selectExist(String fromId, String toId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertChatRoom(ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteChatRoom(int roomNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countNotReadInChatRoom(int roomNo, String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
