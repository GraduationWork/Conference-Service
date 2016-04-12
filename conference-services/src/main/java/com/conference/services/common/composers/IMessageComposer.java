package com.conference.services.common.composers;

public interface IMessageComposer<Entity,MessageType> {
	public MessageType compose(Entity entity);
}
