package com.conference.services.common.transformers;

import java.util.Map;

public interface ITransformer<InputType, OutputType> {
	public OutputType transform(InputType inputType, Map<String, Object> params);
}
