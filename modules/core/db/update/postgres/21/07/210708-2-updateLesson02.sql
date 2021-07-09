alter table SCHEDULE_LESSON rename column classroom_id to classroom_id__u70400 ;
alter table SCHEDULE_LESSON alter column classroom_id__u70400 drop not null ;
drop index IDX_SCHEDULE_LESSON_ON_CLASSROOM ;
