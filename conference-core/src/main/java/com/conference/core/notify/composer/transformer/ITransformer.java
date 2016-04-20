package com.conference.core.notify.composer.transformer;

import java.util.Map;

public interface ITransformer<InputType, OutputType> {
	OutputType transform(InputType inputType, Map<String, Object> params);
}
