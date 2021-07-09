alter table SCHEDULE_CLASSROOM rename column number_ to number___u33091 ;
alter table SCHEDULE_CLASSROOM alter column number___u33091 drop not null ;
-- alter table SCHEDULE_CLASSROOM add column NUMBER_ varchar(255) ^
-- update SCHEDULE_CLASSROOM set NUMBER_ = <default_value> ;
-- alter table SCHEDULE_CLASSROOM alter column number_ set not null ;
alter table SCHEDULE_CLASSROOM add column NUMBER_ varchar(255) ;
