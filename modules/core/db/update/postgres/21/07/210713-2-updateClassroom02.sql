alter table SCHEDULE_CLASSROOM rename column lesson_id to lesson_id__u23884 ;
alter table SCHEDULE_CLASSROOM drop constraint FK_SCHEDULE_CLASSROOM_ON_LESSON ;
drop index IDX_SCHEDULE_CLASSROOM_ON_LESSON ;
