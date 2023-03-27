package com.itwill.my_real_korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.ChatMsgDao;
import com.itwill.my_real_korea.dao.ChatRoomDao;
import com.itwill.my_real_korea.dto.ChatMsg;
import com.itwill.my_real_korea.dto.ChatRoom;

@Service
public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatRoomDao chatRoomDao;
	
	@Autowired
	private ChatMsgDao chatMsgDao;

	public ChatServiceImpl() {
	}
	
	@Override
	public List<ChatRoom> selectAll(String userId) {
		return null;
	}

	@Override
	public ChatRoom selectCheckByRoomNo(int roomNo) {
		return null;
	}

	@Override
	public int chatRoomExistById(String fromId, String toId) {
		return 0;
	}

	@Override
	public boolean duplicateCheck(String fromId, String toId) {
		return false;
	}

	@Override
	public List<ChatRoom> selectExist(String fromId, String toId) {
		return null;
	}

	@Override
	public int insertChatRoom(ChatRoom chatRoom) {
		return 0;
	}

	@Override
	public int deleteChatRoom(int roomNo) {
		return 0;
	}

	@Override
	public int countNotReadInChatRoom(int roomNo, String userId) {
		return 0;
	}

	@Override
	public List<ChatMsg> selectByRoomNo(int roomNo) {
		return null;
	}

	@Override
	public ChatMsg selectByMsgNo(int msgNo) {
		return null;
	}

	@Override
	public ChatMsg selectNotReadMsg(int roomNo, String userId) {
		return null;
	}

	@Override
	public int countNotReadMsg(int roomNo, String userId) {
		return 0;
	}

	@Override
	public List<ChatMsg> selectAllNotReadMsg(String userId) {
		return null;
	}

	@Override
	public int countAllNotReadMsg(String userId) {
		return 0;
	}

	@Override
	public int updateReadMsg(int roomNo, String userId) {
		return 0;
	}

	@Override
	public int deleteChatMsg(int msgNo) {
		return 0;
	}

	@Override
	public int updateDeletedMsg(int msgNo) {
		return 0;
	}

	@Override
	public int insertChatMsg(ChatMsg chatMsg) {
		return 0;
	}
	
	
	
}
