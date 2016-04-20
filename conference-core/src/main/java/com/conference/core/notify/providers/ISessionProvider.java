package com.conference.core.notify.providers;


public interface ISessionProvider<T> {
	public T createMessage();
}
