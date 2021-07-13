alter table SCHEDULE_LESSON rename column classroom_id to classroom_id__u95598 ;
alter table SCHEDULE_LESSON alter column classroom_id__u95598 drop not null ;
alter table SCHEDULE_LESSON drop constraint FK_SCHEDULE_LESSON_ON_CLASSROOM ;
drop index IDX_SCHEDULE_LESSON_ON_CLASSROOM ;
