package com.company.schedule.web.screens.lesson;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Lesson;

@UiController("schedule_Lesson.browse")
@UiDescriptor("lesson-browse.xml")
@LookupComponent("lessonsTable")
@LoadDataBeforeShow
public class LessonBrowse extends StandardLookup<Lesson> {
}