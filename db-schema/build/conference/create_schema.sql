--postgresql
CREATE DATABASE conferencedb;
CREATE USER conferencedb_user WITH password '0';
GRANT ALL privileges ON DATABASE conferencedb TO conferencedb_user;