package com.company.schedule.web.screens.teacher;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Teacher;

@UiController("schedule_Teacher.edit")
@UiDescriptor("teacher-edit.xml")
@EditedEntityContainer("teacherDc")
@LoadDataBeforeShow
public class TeacherEdit extends StandardEditor<Teacher> {
}