alter table SCHEDULE_LESSON add column DURATION time ^
update SCHEDULE_LESSON set DURATION = current_time where DURATION is null ;
alter table SCHEDULE_LESSON alter column DURATION set not null ;
