alter table SCHEDULE_LESSON add constraint FK_SCHEDULE_LESSON_ON_TEACHER foreign key (TEACHER_ID) references SCHEDULE_TEACHER(ID);
alter table SCHEDULE_LESSON add constraint FK_SCHEDULE_LESSON_ON_GROUP foreign key (GROUP_ID) references SCHEDULE_GROUP(ID);
create index IDX_SCHEDULE_LESSON_ON_TEACHER on SCHEDULE_LESSON (TEACHER_ID);
create index IDX_SCHEDULE_LESSON_ON_GROUP on SCHEDULE_LESSON (GROUP_ID);