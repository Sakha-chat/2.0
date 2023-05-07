package com.app.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Answer;
import com.app.entities.Chat;
import com.app.entities.Message;
import com.app.entities.SakhaRequest;
import com.app.entities.SakhaResponse;
import com.app.entities.User;
import com.app.helper.PythonController;
import com.app.services.ChatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(maxAge=3600,origins="*")
public class ChatController {

	private String prev_message="";
	private List<String> userKeywords=new ArrayList<>();
	@Autowired
	ChatService chatService;
	@ResponseBody
	@PostMapping(path="/message",consumes="application/json")
	public ResponseEntity<SakhaResponse> getMessage(HttpSession session,@RequestBody String message) throws JsonMappingException, JsonProcessingException
	{
//		url-http://localhost:8080/message

		ObjectMapper op=new ObjectMapper();
		System.out.println(message);
		Message msg=op.readValue(message, Message.class);
		SakhaRequest request=new SakhaRequest();
		request.setPrevMessage(prev_message);
		request.setUserInput(msg.getMessage());
		request.setUser_keyword(userKeywords);
		String requestJson=op.writeValueAsString(request);
		System.out.println(requestJson);
		PythonController con=new PythonController();
		String response=con.sendMessageToPython(op.writeValueAsString(requestJson));
		
		SakhaResponse ans=op.readValue(response,SakhaResponse.class);
		Chat chat=new Chat();
		User activeUser=(User) session.getAttribute("activeUser");
		LocalDateTime date=LocalDateTime.now();
		chat.setChatDate(date);
		chat.setM_intent(ans.getM_intent());
		chat.setM_opinion(ans.getM_opinion());
		chat.setM_sentiment(ans.getM_sentiment());
		chat.setM_topic(ans.getM_topic());
		chat.setPrev_final(ans.getPrev_final());
		chat.setR_score(ans.getR_score());
		chat.setSakhaResponse(ans.getAnswer());
		chat.setUserId(activeUser.getUserId());
		chat.setUserMessage(msg.getMessage());
		chat.setKeyWords(ans.getUser_keyword().toString());
		chatService.saveChat(chat);
		prev_message=ans.getAnswer();
		userKeywords=ans.getUser_keyword();
		return ResponseEntity.status(HttpStatus.OK).body(ans);
	}
	
	@ResponseBody
	@RequestMapping("/getCurrentUser")
	public ResponseEntity<User> getUser(HttpSession session)
	{
		User user=(User)session.getAttribute("activeUser");
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
}
