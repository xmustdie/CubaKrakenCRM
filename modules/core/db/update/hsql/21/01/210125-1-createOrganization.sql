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
);