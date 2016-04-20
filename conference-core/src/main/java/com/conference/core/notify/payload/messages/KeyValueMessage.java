package com.conference.core.notify.payload.messages;

import java.util.Map;

public class KeyValueMessage implements IMessage<Map<String,Object>>{

	private Map<String,Object> params;
	
	
	public KeyValueMessage(Map<String,Object> params ) {
		this.params = params;
	}
	
	@Override
	public Map<String, Object> getMessage() {
		return params;
	}

}
