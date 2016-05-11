package com.conference.core.notify.validator;

import com.conference.core.notify.payload.IPayload;

public interface IValidator<Type extends IPayload<?,?>> {
	void validate(Type payload);
}
