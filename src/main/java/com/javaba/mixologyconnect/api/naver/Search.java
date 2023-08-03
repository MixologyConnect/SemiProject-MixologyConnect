package com.javaba.mixologyconnect.api.naver;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Search {

    public static String searchPlace(String keyword){

    	String responseBody = null;

        try {
        	keyword = URLEncoder.encode(keyword, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/local.json?query="+keyword+"&display=10&start=1&sort=comment";

            Map<String, String> requestHeaders = new HashMap<>();

            requestHeaders.put("X-Naver-Client-Id", "aDYqFThIR5qYTNmngyA2");
            requestHeaders.put("X-Naver-Client-Secret", "wOFMNbEuY4");
            responseBody = new Connection().get(apiURL, requestHeaders);
        } catch (Exception e) {
        	e.printStackTrace();
        }

        return responseBody;
    }

}
