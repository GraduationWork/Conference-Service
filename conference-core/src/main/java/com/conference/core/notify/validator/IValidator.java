package com.conference.core.notify.validator;

import com.conference.core.notify.payload.IPayload;

public interface IValidator {
	void validate(IPayload<?, ?> payload);
}
