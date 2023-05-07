package com.app.entities;

import java.util.List;

import jakarta.persistence.Entity;

public class SakhaResponse {
	String answer;
	List<String> user_keyword;
	String prev_final;
	String r_score;
	String m_topic;
	String m_opinion;
	String m_sentiment;
	String m_intent;
	public String getAnswer() {
		return answer;
	}
	public List<String> getUser_keyword() {
		return user_keyword;
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
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void setUser_keyword(List<String> user_keyword) {
		this.user_keyword = user_keyword;
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
	
}
