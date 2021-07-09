package com.company.schedule.web.screens.student;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Student;

@UiController("schedule_Student.browse")
@UiDescriptor("student-browse.xml")
@LookupComponent("studentsTable")
@LoadDataBeforeShow
public class StudentBrowse extends StandardLookup<Student> {
}