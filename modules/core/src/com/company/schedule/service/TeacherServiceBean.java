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

    @Override
    public boolean isFree(String email, LocalDate day, LocalTime startTime, LocalTime endTime) {
        List<Lesson> list = dataManager.load(Lesson.class)
                .query("select e from schedule_Lesson e where e.teacher.email = :email and e.day = :day")
                .parameter("day",day)
                .parameter("email",email)
                .list();
        for (Lesson lesson: list){
            if ((lesson.getTime().isBefore(endTime) && lesson.getEndTime().isAfter(startTime) ||
                    lesson.getEndTime().isBefore(endTime) && lesson.getEndTime().isAfter(startTime) ||
                    lesson.getEndTime().isBefore(endTime) && lesson.getTime().isAfter(startTime) ||
                    lesson.getTime().isBefore(startTime) && lesson.getEndTime().isAfter(endTime)))
                return false;
        }
        return true;
    }
}