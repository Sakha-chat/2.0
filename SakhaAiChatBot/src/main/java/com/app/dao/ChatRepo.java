package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Chat;

public interface ChatRepo extends JpaRepository<Chat, Integer>{

}
