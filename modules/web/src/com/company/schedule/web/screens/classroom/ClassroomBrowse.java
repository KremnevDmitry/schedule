package com.company.schedule.web.screens.classroom;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Classroom;

@UiController("schedule_Classroom.browse")
@UiDescriptor("classroom-browse.xml")
@LookupComponent("classroomsTable")
@LoadDataBeforeShow
public class ClassroomBrowse extends StandardLookup<Classroom> {
}