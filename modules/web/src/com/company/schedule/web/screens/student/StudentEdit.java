package com.company.schedule.web.screens.student;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Student;

@UiController("schedule_Student.edit")
@UiDescriptor("student-edit.xml")
@EditedEntityContainer("studentDc")
@LoadDataBeforeShow
public class StudentEdit extends StandardEditor<Student> {
}