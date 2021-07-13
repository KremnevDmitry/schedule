package com.company.schedule.service;

import com.company.schedule.entity.Classroom;
import com.company.schedule.entity.Lesson;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service(ClassroomService.NAME)
public class ClassroomServiceBean implements ClassroomService {

    @Inject
    private DataManager dataManager;
    @Inject
    private TimeIntersectionService timeIntersectionService;

    @Override
    public boolean isClassroomFree(Lesson thisLesson,Classroom classroom, LocalDate day, LocalTime startTime, LocalTime endTime) {
        List<Lesson> list = dataManager.load(Lesson.class)
                .query("select e from schedule_Lesson e where e.day = :day and e.classroom = :classroom")
                .parameter("day",day)
                .parameter("classroom",classroom)
                .view("lesson-view")
                .list();
        return timeIntersectionService.isIntersection(list,thisLesson,startTime,endTime);
    }

    @Override
    public boolean isAvailableSize(Classroom classroom, int numberOfGroups) {
        return classroom.getSize() >= numberOfGroups;
    }
}