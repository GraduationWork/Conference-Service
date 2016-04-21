package com.conference.core.domain;

import java.io.Serializable;


public enum RolesEnum implements Serializable{
	ROLE_CONFERENCE_ADMIN(),
	ROLE_CONFERENCE_MODERATOR(),
	ROLE_CONFERENCE_USER();
	
}
