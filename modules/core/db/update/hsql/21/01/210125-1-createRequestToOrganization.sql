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
    ORGANIZATION_ID varchar(36) not null,
    TEXT_BODY_OF_REQUEST longvarchar,
    --
    primary key (ID)
);