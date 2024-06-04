package org.enmovil.atf.data;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConfig {
	
	JSONParser parser = null;
	JSONObject json = null;
	ObjectMapper objectMapper = null;
	
	public LoginData getLoginData() {
		LoginData loginData = null;
		try {
			parser = new JSONParser();
			json = (JSONObject) parser.parse(new FileReader("src/main/resources/AMNS-Data/login-data.json"));
			objectMapper = new ObjectMapper();
			loginData = objectMapper.readValue(json.toString(), LoginData.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginData;
	} 
	
	
	

}
