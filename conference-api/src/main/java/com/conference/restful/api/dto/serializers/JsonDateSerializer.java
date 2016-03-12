package com.conference.restful.api.dto.serializers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class JsonDateSerializer extends JsonSerializer<Date> {

	private static final SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy HH:mm:ss z");
	{
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
	}
	
	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
		if (date != null) {
			String dateFormatted = format.format(date);
			
			jsonGenerator.writeString(dateFormatted);
		} else  {
			jsonGenerator.writeNull();
		}
	}

}
