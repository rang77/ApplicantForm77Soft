package helper;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import model.error.PageError;

public class ServletHelper {
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	public ServletHelper(){
		MAPPER.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
	}
	
	public static PageError handleAPIException(String message){
		try {
			List<PageError> error = MAPPER.readValue(message, new TypeReference<List<PageError>>(){});
			return error.get(0);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}	
}
