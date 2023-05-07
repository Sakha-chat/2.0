package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.ChatDao;
import com.app.entities.Chat;

@Component
public class ChatService {
	@Autowired
	ChatDao chatDao;
	public Chat saveChat(Chat chat)
	{
		return chatDao.saveChat(chat);
	}
}
