package com.app.entities;

public class Message {
	String message;
//	String prev_message;
//	
//	public String getPrev_message() {
//		return prev_message;
//	}
//
//	public void setPrev_message(String prev_message) {
//		this.prev_message = prev_message;
//	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + "]";
	}
	
	
}
