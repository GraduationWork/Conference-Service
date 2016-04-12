package com.conference.services.confirmation;

import com.conference.dataprovider.domain.User;

public interface IConfirmationProvider {
	public void sendConfirmation(User user);
}
