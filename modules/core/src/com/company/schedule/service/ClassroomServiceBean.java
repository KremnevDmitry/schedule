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

    @Override
    public boolean isClassroomFree(Classroom classroom, LocalDate day, LocalTime startTime, LocalTime endTime) {
        List<Lesson> list = dataManager.load(Lesson.class)
                .query("select e from schedule_Lesson e where e.day = :day and e.classroom = :classroom")
                .parameter("day",day)
                .parameter("classroom",classroom)
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

    @Override
    public boolean isAvailableSize(Classroom classroom, int numberOfGroups) {
        return classroom.getSize() >= numberOfGroups;
    }
}