create database if not exists russia_iran;
use russia_iran;
CREATE TABLE if not exists SentMessage (
	messageType varchar(15) not null,
	preparationDateTime timestamp not null,
    consignmentID varchar(50) not null,
    envelopeID varchar(36) not null,
    initialEnvelopeID varchar(36) not null,
    contents text not null,
    primary key (envelopeID)
);





CREATE TABLE if not exists RecievedMessage (
	messageType varchar(15) not null,
	preparationDateTime timestamp not null,
    consignmentID varchar(50) not null,
    envelopeID varchar(36) not null,
    initialEnvelopeID varchar(36) not null,
    contents text not null,
    primary key (envelopeID)
);



create table if not exists RecievedMessagesList(
	envelopeID varchar(36),
    status varchar(15),
    date_time timestamp not null,
    primary key (envelopeID)
);

