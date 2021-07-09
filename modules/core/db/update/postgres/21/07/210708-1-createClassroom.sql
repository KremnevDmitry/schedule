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
);