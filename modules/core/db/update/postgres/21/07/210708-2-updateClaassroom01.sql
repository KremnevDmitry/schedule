alter table SCHEDULE_CLAASSROOM rename column type_ to type___u10743 ;
alter table SCHEDULE_CLAASSROOM alter column type___u10743 drop not null ;
alter table SCHEDULE_CLAASSROOM add column TYPE_ integer ^
update SCHEDULE_CLAASSROOM set TYPE_ = 0 where TYPE_ is null ;
alter table SCHEDULE_CLAASSROOM alter column TYPE_ set not null ;
