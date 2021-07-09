create table SCHEDULE_LESSON_GROUP_LINK (
    LESSON_ID uuid,
    GROUP_ID uuid,
    primary key (LESSON_ID, GROUP_ID)
);
