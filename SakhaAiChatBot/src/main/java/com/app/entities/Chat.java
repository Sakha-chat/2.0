package com.app.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Chat {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int chatId;
	int userId;
	@Column(columnDefinition = "longtext")
	String userMessage;
	@Column(columnDefinition="longtext")
	String sakhaResponse;
	String prev_final;
	String r_score;
	String m_topic;
	String m_opinion;
	String m_sentiment;
	String m_intent;
	LocalDateTime chatDate;
	@Column(columnDefinition="longtext")
	String keyWords;
	
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getPrev_final() {
		return prev_final;
	}
	public String getR_score() {
		return r_score;
	}
	public String getM_topic() {
		return m_topic;
	}
	public String getM_opinion() {
		return m_opinion;
	}
	public String getM_sentiment() {
		return m_sentiment;
	}
	public String getM_intent() {
		return m_intent;
	}
	
	public void setPrev_final(String prev_final) {
		this.prev_final = prev_final;
	}
	public void setR_score(String r_score) {
		this.r_score = r_score;
	}
	public void setM_topic(String m_topic) {
		this.m_topic = m_topic;
	}
	public void setM_opinion(String m_opinion) {
		this.m_opinion = m_opinion;
	}
	public void setM_sentiment(String m_sentiment) {
		this.m_sentiment = m_sentiment;
	}
	public void setM_intent(String m_intent) {
		this.m_intent = m_intent;
	}
	public int getChatId() {
		return chatId;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public String getSakhaResponse() {
		return sakhaResponse;
	}
	public LocalDateTime getChatDate() {
		return chatDate;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public void setSakhaResponse(String sakhaResponse) {
		this.sakhaResponse = sakhaResponse;
	}
	public void setChatDate(LocalDateTime chatDate) {
		this.chatDate = chatDate;
	}
	
}
