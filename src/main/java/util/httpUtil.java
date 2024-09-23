package util;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.util.StringUtils;

public class httpUtil {
	
	private String values;
	
	public httpUtil(String value) {
		this.values = value;
	}
	
	public <T> T toModel(Class<T> tClass) {
		try {
//			return new ObjectMapper().readValue(values,tClass);
			return new ObjectMapper().readValue(values,tClass);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static httpUtil of(BufferedReader reader ) {
		StringBuilder json = new StringBuilder();
		try {
			String line ;
			while((line = reader.readLine()) != null) {
				json.append(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return new httpUtil(json.toString());
	}
}
