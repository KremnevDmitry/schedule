package com.company.schedule.service;

import com.company.schedule.entity.Lesson;
import com.company.schedule.entity.Teacher;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service(TeacherService.NAME)
public class TeacherServiceBean implements TeacherService {

    @Inject
    private DataManager dataManager;
    @Inject
    private TimeIntersectionService timeIntersectionService;

    @Override
    public boolean isFree(Lesson thisLesson, String email, LocalDate day, LocalTime startTime, LocalTime endTime) {
        List<Lesson> list = dataManager.load(Lesson.class)
                .query("select e from schedule_Lesson e where e.teacher.email = :email and e.day = :day")
                .parameter("day",day)
                .parameter("email",email)
                .view("lesson-view")
                .list();
        return timeIntersectionService.isIntersection(list,thisLesson,startTime,endTime);
    }
}