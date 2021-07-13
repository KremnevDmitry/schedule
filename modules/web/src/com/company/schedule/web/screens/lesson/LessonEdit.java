package com.company.schedule.web.screens.lesson;

import com.company.schedule.entity.Classroom;
import com.company.schedule.entity.Group;
import com.company.schedule.entity.Teacher;
import com.company.schedule.service.ClassroomService;
import com.company.schedule.service.GroupService;
import com.company.schedule.service.TeacherService;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Lesson;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalTime;

@UiController("schedule_Lesson.edit")
@UiDescriptor("lesson-edit.xml")
@EditedEntityContainer("lessonDc")
@LoadDataBeforeShow
public class LessonEdit extends StandardEditor<Lesson> {
    @Inject
    private ClassroomService classroomService;
    @Inject
    private PickerField<Classroom> classroomField;
    @Inject
    private DateField<LocalDate> dayField;
    @Inject
    private TimeField<LocalTime> timeField;
    @Inject
    private TimeField<LocalTime> endTimeField;
    @Inject
    private MessageDialogFacet messagedialog_1;
    @Inject
    private Table<Group> groupTable;
    @Inject
    private TeacherService teacherService;
    @Inject
    private PickerField<Teacher> teacherField;
    @Inject
    private GroupService groupService;
    @Inject
    private InstanceContainer<Lesson> lessonDc;


    @Subscribe("checkBtn")
    public void onCheckBtnClick(Button.ClickEvent event) {



        //проверка на доступность аудитории

        if (!classroomService.isClassroomFree(lessonDc.getItemOrNull(),classroomField.getValue(), dayField.getValue(), timeField.getValue(),endTimeField.getValue())){
            messagedialog_1.setMessage("The selected classroom already taken");
            messagedialog_1.show();
            return;
        }

        //проверка на соответствие размера аудитории
        if(!classroomService.isAvailableSize(classroomField.getValue(),groupTable.getItems().size())){
            messagedialog_1.setMessage("The selected classroom does not fit number of groups");
            messagedialog_1.show();
            return;
        }

        //проверка на занятость преподавателя
        if(!teacherService.isFree(lessonDc.getItemOrNull(),teacherField.getValue().getEmail(),dayField.getValue(), timeField.getValue(),endTimeField.getValue())){
            messagedialog_1.setMessage("The teacher already busy at this time");
            messagedialog_1.show();
            return;
        }

       ///проверка на занятость групп
        for(Group group:groupTable.getItems().getItems()) {
            if(!groupService.isFree(lessonDc.getItemOrNull(), group,dayField.getValue(), timeField.getValue(),endTimeField.getValue())){
                messagedialog_1.setMessage("The group " + group.getGroupNumber() + " already busy at this time");
                messagedialog_1.show();
                return;
            }
        }

        if(groupTable.getItems().size() == 0){
            messagedialog_1.setMessage("You must select at least one group");
            messagedialog_1.show();
            return;
        }

        close(StandardOutcome.COMMIT);
    }

}