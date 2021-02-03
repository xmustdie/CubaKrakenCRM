create table MYAPP_REQUEST_TO_ORGANIZATION_USER_LINK (
    REQUEST_TO_ORGANIZATION_ID varchar(36) not null,
    USER_ID varchar(36) not null,
    primary key (REQUEST_TO_ORGANIZATION_ID, USER_ID)
);
