-- alter table SCHEDULE_LESSON add column CLASSROOM_ID uuid ^
-- update SCHEDULE_LESSON set CLASSROOM_ID = <default_value> ;
-- alter table SCHEDULE_LESSON alter column CLASSROOM_ID set not null ;
alter table SCHEDULE_LESSON add column CLASSROOM_ID uuid not null ;
