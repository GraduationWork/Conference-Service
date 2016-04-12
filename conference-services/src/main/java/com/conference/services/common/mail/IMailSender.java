package com.conference.services.common.mail;

public interface IMailSender<T> {
	public void send(T t);
}
