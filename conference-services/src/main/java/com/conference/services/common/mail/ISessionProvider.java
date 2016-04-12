package com.conference.services.common.mail;


public interface ISessionProvider<T> {
	public T createMessage();
}
