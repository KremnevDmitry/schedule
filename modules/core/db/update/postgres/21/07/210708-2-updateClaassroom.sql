alter table SCHEDULE_CLAASSROOM rename column type_ to type___u60257 ;
alter table SCHEDULE_CLAASSROOM alter column type___u60257 drop not null ;
alter table SCHEDULE_CLAASSROOM add column TYPE_ varchar(50) ^
alter table SCHEDULE_CLAASSROOM alter column TYPE_ set not null ;
