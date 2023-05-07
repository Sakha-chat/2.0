package com.app.entities;

import java.util.List;

public class SakhaRequest {

	String userInput;
	String prevMessage;
	List<String> user_keyword;
	
	public List<String> getUser_keyword() {
		return user_keyword;
	}
	public void setUser_keyword(List<String> user_keyword) {
		this.user_keyword = user_keyword;
	}
	public String getUserInput() {
		return userInput;
	}
	public String getPrevMessage() {
		return prevMessage;
	}
	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}
	public void setPrevMessage(String prevMessage) {
		this.prevMessage = prevMessage;
	}
	@Override
	public String toString() {
		return "SakhaRequest [userInput=" + userInput + ", prevMessage=" + prevMessage + "]";
	}
	
	
}
