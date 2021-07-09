package com.company.schedule.web.screens.lesson;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Lesson;

@UiController("schedule_Lesson.edit")
@UiDescriptor("lesson-edit.xml")
@EditedEntityContainer("lessonDc")
@LoadDataBeforeShow
public class LessonEdit extends StandardEditor<Lesson> {
}