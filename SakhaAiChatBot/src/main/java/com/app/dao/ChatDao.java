package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.entities.Chat;

@Component
public class ChatDao {
	@Autowired
	ChatRepo chatRepo;

	public Chat saveChat(Chat chat) {
		Chat savedChat = chatRepo.save(chat);
		return savedChat;
	}
}
