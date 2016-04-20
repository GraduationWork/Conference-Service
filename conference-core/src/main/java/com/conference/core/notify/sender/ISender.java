package com.conference.core.notify.sender;

import com.conference.core.notify.sender.request.IRequest;

public interface ISender<RequestType> {
	void send(IRequest<RequestType> request);
}
