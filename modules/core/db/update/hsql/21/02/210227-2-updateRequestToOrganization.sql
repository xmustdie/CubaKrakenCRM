-- update MYAPP_REQUEST_TO_ORGANIZATION set ORGANIZATION_ID = <default_value> where ORGANIZATION_ID is null ;
alter table MYAPP_REQUEST_TO_ORGANIZATION alter column ORGANIZATION_ID set not null ;
