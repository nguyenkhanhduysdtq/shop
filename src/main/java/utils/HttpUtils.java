package utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {
   
   private	String value;
   
   
   
   public HttpUtils() {
	super();
}

public HttpUtils(String value) {
	this.value = value;
}




   public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}

public static <T> T toAccount(Class<T> tcClass,String value) {
	   
	   ObjectMapper mapper=new ObjectMapper();
	   
	   
	   
	   try {
		return mapper.readValue(value, tcClass);
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   return null;
	   
   }


public static HttpUtils jsonToString(BufferedReader reader) {
	   
	   StringBuffer buffer=new StringBuffer();
	   
	   String line;
	   
	   try {
		while((line=reader.readLine())!=null) {
			   buffer.append(line);
		   }
	} catch (IOException e) {
		
		System.err.println(e.getMessage());
	}
	   
	   return new HttpUtils(buffer.toString());
   }


	
	
}
