-- begin MYAPP_ORGANIZATION
create table MYAPP_ORGANIZATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME_ORGANIZATION varchar(255) not null,
    SHORT_NAME_ORGANIZATION varchar(255) not null,
    EMAIL varchar(50),
    PHONE_NUMBER varchar(50),
    TAXES_TYPE_ORGANIZATION varchar(50),
    --
    primary key (ID)
)^
-- end MYAPP_ORGANIZATION
-- begin MYAPP_REQUEST_TO_ORGANIZATION
create table MYAPP_REQUEST_TO_ORGANIZATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_OF_REQUEST bigint,
    ORGANIZATION_ID varchar(36),
    TEXT_BODY_OF_REQUEST longvarchar,
    IS_CANCELED boolean,
    --
    primary key (ID)
)^
-- end MYAPP_REQUEST_TO_ORGANIZATION
-- begin MYAPP_REQUEST_TO_ORGANIZATION_USER_LINK
create table MYAPP_REQUEST_TO_ORGANIZATION_USER_LINK (
    REQUEST_TO_ORGANIZATION_ID varchar(36) not null,
    USER_ID varchar(36) not null,
    primary key (REQUEST_TO_ORGANIZATION_ID, USER_ID)
)^
-- end MYAPP_REQUEST_TO_ORGANIZATION_USER_LINK
-- begin SEC_USER
alter table SEC_USER add column PHONE_NUMBER varchar(50) ^
alter table SEC_USER add column DTYPE varchar(31) ^
update SEC_USER set DTYPE = 'myapp_ExtUser' where DTYPE is null ^
-- end SEC_USER
