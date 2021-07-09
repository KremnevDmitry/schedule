-- update SCHEDULE_CLASSROOM set NUMBER_ = <default_value> where NUMBER_ is null ;
alter table SCHEDULE_CLASSROOM alter column NUMBER_ set not null ;
