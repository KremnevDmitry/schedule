-- alter table SCHEDULE_STUDENT add column GROUP_ID uuid ^
-- update SCHEDULE_STUDENT set GROUP_ID = <default_value> ;
-- alter table SCHEDULE_STUDENT alter column GROUP_ID set not null ;
alter table SCHEDULE_STUDENT add column GROUP_ID uuid not null ;
