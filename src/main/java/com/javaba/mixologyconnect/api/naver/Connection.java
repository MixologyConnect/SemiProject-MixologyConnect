package com.javaba.mixologyconnect.api.naver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Connection {
	public String get(String url, Map<String, String> requestHeaders) throws Exception {
		String result;

		HttpURLConnection conn = connect(url);
		conn.setRequestMethod("GET");

		for(Map.Entry<String, String> header :requestHeaders.entrySet()) conn.setRequestProperty(header.getKey(), header.getValue());
		int responseCode = conn.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) result = readBody(conn.getInputStream());
		else result = readBody(conn.getErrorStream());

		conn.disconnect();

		return result;
	}

	private HttpURLConnection connect(String apiUrl) throws Exception {
		URL url = new URL(apiUrl);
		return (HttpURLConnection)url.openConnection();
	}

	private String readBody(InputStream body) throws Exception {
		InputStreamReader streamReader = new InputStreamReader(body, StandardCharsets.UTF_8);
		BufferedReader lineReader = new BufferedReader(streamReader);
		StringBuilder responseBody = new StringBuilder();
		String line;
		while ((line = lineReader.readLine()) != null) {
			responseBody.append(line);
		}
		return responseBody.toString();
	}

}
