-- begin SCHEDULE_STUDENT
create table SCHEDULE_STUDENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FULL_NAME varchar(255) not null,
    GRADE_BOOK integer not null,
    GROUP_ID uuid not null,
    --
    primary key (ID)
)^
-- end SCHEDULE_STUDENT
-- begin SCHEDULE_GROUP
create table SCHEDULE_GROUP (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    GROUP_NUMBER integer not null,
    --
    primary key (ID)
)^
-- end SCHEDULE_GROUP

-- begin SCHEDULE_LESSON
create table SCHEDULE_LESSON (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DAY_ date not null,
    TIME_ time not null,
    DURATION time not null,
    TEACHER_ID uuid not null,
    GROUP_ID uuid not null,
    CLASSROOM_ID uuid not null,
    --
    primary key (ID)
)^
-- end SCHEDULE_LESSON
-- begin SCHEDULE_TEACHER
create table SCHEDULE_TEACHER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FULL_NAME varchar(255) not null,
    EMAIL varchar(255) not null,
    --
    primary key (ID)
)^
-- end SCHEDULE_TEACHER
-- begin SCHEDULE_CLASSROOM
create table SCHEDULE_CLASSROOM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TYPE_ integer not null,
    NUMBER_ integer not null,
    SIZE_ integer not null,
    --
    primary key (ID)
)^
-- end SCHEDULE_CLASSROOM
