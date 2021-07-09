alter table SCHEDULE_LESSON rename column group_id to group_id__u83234 ;
alter table SCHEDULE_LESSON alter column group_id__u83234 drop not null ;
alter table SCHEDULE_LESSON drop constraint FK_SCHEDULE_LESSON_ON_GROUP ;
drop index IDX_SCHEDULE_LESSON_ON_GROUP ;
