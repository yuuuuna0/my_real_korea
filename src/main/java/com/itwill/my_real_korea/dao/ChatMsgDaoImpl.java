package com.itwill.my_real_korea.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.ChatRoom;
import com.itwill.my_real_korea.mapper.ChatMsgMapper;
import com.itwill.my_real_korea.mapper.NoticeMapper;

@Repository
public class ChatMsgDaoImpl implements ChatMsgDao{

	@Autowired
	private ChatMsgMapper chatMsgMapper;
	
	public ChatMsgDaoImpl() {
		System.out.println("ChatMsgDaoImpl 기본생성자 호출");
	}
	public ChatMsgMapper getChatMsgMapper() {
		return chatMsgMapper;
	}
	public void setChatMsgMapper(ChatMsgMapper chatMsgMapper) {
		System.out.println(">>> ChatMsgDaoImpl():setChatMsgMapper()호출");
		this.chatMsgMapper = chatMsgMapper;
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
