package com.conference.services.common.listeners;

import java.io.Serializable;

public interface IMessageHandler {
	public void handleMessage(Serializable message);
}
