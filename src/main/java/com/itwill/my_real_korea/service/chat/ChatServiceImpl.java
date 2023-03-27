package com.itwill.my_real_korea.service.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.chat.ChatMsgDao;
import com.itwill.my_real_korea.dao.chat.ChatRoomDao;
import com.itwill.my_real_korea.dto.chat.ChatMsg;
import com.itwill.my_real_korea.dto.chat.ChatRoom;

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
		return chatRoomDao.selectAll(userId);
	}

	@Override
	public ChatRoom selectCheckByRoomNo(int roomNo) {
		return chatRoomDao.selectCheckByRoomNo(roomNo);
	}

	/*
	채팅방 번호 찾기
	채팅방 존재 : 방번호 반환
	채팅방 존재X : -999 반환
	 */
	@Override
	public int chatRoomNoSearchById(String fromId, String toId) {
		ChatRoom chatRoom = chatRoomDao.selectById(fromId, toId);
		if (chatRoom != null) {
			// fromId, toId 의 채팅방 존재
			return chatRoom.getRoomNo(); 
		} else {
			return -999;
		}
	}

	/*
	 * 0 : 채팅방 중복
	 * 1 : 채팅방 중복X
	 */
	@Override
	public boolean duplicateCheck(String fromId, String toId) {
		List<ChatRoom> chatRoomExistList = chatRoomDao.selectExist(fromId, toId);
		if (chatRoomExistList.size() >= 1) {
			// fromId, toId 의 채팅방 중복
			return true; 
		} else {
			return false;
		}
	}

	@Override
	public int insertChatRoom(ChatRoom chatRoom) {
		return chatRoomDao.insertChatRoom(chatRoom);
	}

	@Override
	public int deleteChatRoom(int roomNo) {
		return chatRoomDao.deleteChatRoom(roomNo);
	}

	@Override
	public int countNotReadInChatRoom(int roomNo, String userId) {
		return chatRoomDao.countNotReadInChatRoom(roomNo, userId);
	}

	@Override
	public List<ChatMsg> selectByRoomNo(int roomNo) {
		return chatMsgDao.selectByRoomNo(roomNo);
	}

	@Override
	public ChatMsg selectByMsgNo(int msgNo) {
		return chatMsgDao.selectByMsgNo(msgNo);
	}

	@Override
	public List<ChatMsg> selectNotReadMsg(int roomNo, String userId) {
		return chatMsgDao.selectNotReadMsg(roomNo, userId);
	}

	@Override
	public int countNotReadMsg(int roomNo, String userId) {
		return chatMsgDao.countNotReadMsg(roomNo, userId);
	}

	@Override
	public List<ChatMsg> selectAllNotReadMsg(String userId) {
		return chatMsgDao.selectAllNotReadMsg(userId);
	}

	@Override
	public int countAllNotReadMsg(String userId) {
		return chatMsgDao.countAllNotReadMsg(userId);
	}

	@Override
	public int updateReadMsg(int roomNo, String userId) {
		return chatMsgDao.updateReadMsg(roomNo, userId);
	}

	@Override
	public int deleteChatMsg(int msgNo) {
		return chatMsgDao.deleteChatMsg(msgNo);
	}

	@Override
	public int updateDeletedMsg(int msgNo) {
		return chatMsgDao.updateDeletedMsg(msgNo);
	}

	@Override
	public int insertChatMsg(ChatMsg chatMsg) {
		return chatMsgDao.insertChatMsg(chatMsg);
	}

	@Override
	public ChatMsg selectLastNotReadMsg(int roomNo, String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
