package com.conference.services.common.sender;

public interface INotificationSender<Type> {
	public void send(Type entity, Action action);
}
