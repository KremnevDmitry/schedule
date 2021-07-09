package com.company.schedule.web.screens.teacher;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Teacher;

@UiController("schedule_Teacher.browse")
@UiDescriptor("teacher-browse.xml")
@LookupComponent("teachersTable")
@LoadDataBeforeShow
public class TeacherBrowse extends StandardLookup<Teacher> {
}