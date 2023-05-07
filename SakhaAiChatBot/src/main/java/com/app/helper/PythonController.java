package com.app.helper;

import java.io.IOException;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class PythonController {

	public String sendMessageToPython(String json) {
		String url = "http://127.0.0.1:8090/predict";
		URI uri = URI.create(url);
		HttpRequest request = HttpRequest.newBuilder(uri)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).POST(BodyPublishers.ofString(json))
				.build();
		HttpClient client = HttpClient.newBuilder().build();
		try {
			String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
			System.out.println("Response recieved");
			System.out.println(response);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
