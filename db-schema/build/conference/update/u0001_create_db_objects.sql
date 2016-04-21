CREATE TABLE USERS (
	USERNAME VARCHAR(255) NOT NULL,
	PASSWORD VARCHAR(255) NOT NULL,
	EMAIL VARCHAR(255) NOT NULL,
	FIRSTNAME VARCHAR(255) NOT NULL,
	LASTNAME VARCHAR(255) NOT NULL,
	IS_ACTIVE boolean NOT NULL DEFAULT false,
	CREATED TIMESTAMP NOT NULL default NOW(),
	UPDATED TIMESTAMP NOT NULL default NOW(),
	PRIMARY KEY(USERNAME)
);

CREATE TABLE ROLES (
	ROLE VARCHAR(255) NOT NULL,
	PRIMARY KEY(ROLE)
);

CREATE TABLE USERS_ROLES (
	USERNAME_ID VARCHAR(255) NOT NULL references USERS(USERNAME),
	ROLE_ID VARCHAR(255) NOT NULL references ROLES(ROLE),
	PRIMARY KEY(USERNAME_ID,ROLE_ID)
);



CREATE TABLE TEMPLATE (
	ID VARCHAR(255) NOT NULL,
	NAME VARCHAR(255) NOT NULL,
	PREVIEW_IMAGE_URL VARCHAR(2082) NOT NULL,
	URL VARCHAR(2082) NOT NULL,
	CREATED TIMESTAMP NOT NULL default NOW(),
	UPDATED TIMESTAMP NOT NULL default NOW(),
	PRIMARY KEY(ID)
); 

CREATE TABLE TAGS (
	TAG VARCHAR(255) NOT NULL,
	PRIMARY KEY(TAG)
);

CREATE TABLE SPEAKERS (
	ID VARCHAR(255) NOT NULL,
	NAME VARCHAR(255) NOT NULL,
	TITLE VARCHAR(255) NOT NULL,
	PHOTO_URL VARCHAR(2082),
	CREATED TIMESTAMP NOT NULL default NOW(),
	UPDATED TIMESTAMP NOT NULL default NOW(),
	PRIMARY KEY(ID)
);

CREATE TABLE PLACES (
	ID VARCHAR(255) NOT NULL,
	COUNTRY VARCHAR(255),
	ADMINISTRATIVE_AREA VARCHAR(255),
	CITY VARCHAR(255),
	STREET VARCHAR(255),
	STREET_NUMBER VARCHAR(255),
	POSITION_X REAL NOT NULL,
	POSITION_Y REAL NOT NULL,
	CREATED TIMESTAMP NOT NULL default NOW(),
	UPDATED TIMESTAMP NOT NULL default NOW(),
	PRIMARY KEY(ID)
);

CREATE TABLE CONFERENCES (
	ID VARCHAR(255) NOT NULL,
	TITLE VARCHAR(255) NOT NULL,
	START_TIME TIMESTAMP NOT NULL,
	END_TIME TIMESTAMP NOT NULL,
	VIDEO_ID VARCHAR(255) NOT NULL,
	PLACE_ID VARCHAR(255) NOT NULL references PLACES(ID),
	PLACE_DETAILS VARCHAR(255),
	TEMPLATE_ID VARCHAR(255) NOT NULL references TEMPLATE(ID),
	CREATED_BY VARCHAR(255) NOT NULL,
	CREATED TIMESTAMP NOT NULL default NOW(),
	UPDATED TIMESTAMP NOT NULL default NOW(),
	PRIMARY KEY(ID)
);

CREATE TABLE STAKEHOLDERS (
	ID INTEGER NOT NULL,
	TEXT VARCHAR(255) NOT NULL,
	ORD INTEGER NOT NULL,
	CONFERENCE_ID VARCHAR(255) NOT NULL,
	PRIMARY KEY(ID)
);


CREATE TABLE CONFERENCE_TAGS (
	CONFERENCE_ID VARCHAR(255) NOT NULL references CONFERENCES(ID),
	TAG VARCHAR(255) NOT NULL references TAGS(TAG),
	PRIMARY KEY(CONFERENCE_ID,TAG)
);

CREATE TABLE CONFERENCE_SPEAKERS (
	CONFERENCE_ID VARCHAR(255) NOT NULL references CONFERENCES(ID),
	SPEAKER_ID VARCHAR(255) NOT NULL references SPEAKERS(ID),
	PRIMARY KEY(CONFERENCE_ID,SPEAKER_ID)
);


CREATE TABLE CONFERENCE_USERS (
	-- id
	USERNAME VARCHAR(255) NOT NULL references USERS(USERNAME),
	CONFERENCE_ID VARCHAR(255) NOT NULL references CONFERENCES(ID),
	REGISTRATION_DATE TIMESTAMP NOT NULL default NOW(),
	PRIMARY KEY(USERNAME,CONFERENCE_ID)
);

CREATE TABLE DEVICES (
	DEVICE_TYPE VARCHAR(255) NOT NULL,
	TOKEN VARCHAR(1000) NOT NULL,
	NAME VARCHAR(1000) NOT NULL,
	IS_ACTIVE boolean NOT NULL DEFAULT false,
	USERNAME VARCHAR(255) NOT NULL references USERS(USERNAME)
);


