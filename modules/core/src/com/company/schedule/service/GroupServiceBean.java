package com.company.schedule.service;

import com.company.schedule.entity.Group;
import com.company.schedule.entity.Lesson;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service(GroupService.NAME)
public class GroupServiceBean implements GroupService {

    @Inject
    private DataManager dataManager;
    @Inject
    private TimeIntersectionService timeIntersectionService;

    @Override
    public boolean isFree(Lesson thisLesson, Group group, LocalDate day, LocalTime startTime, LocalTime endTime) {
        List<Lesson> list = dataManager.load(Lesson.class)
                .query("select e from schedule_Lesson e where e.day = :day and e.group = :group")
                .parameter("day",day)
                .parameter("group",group)
                .view("lesson-view")
                .list();
        return timeIntersectionService.isIntersection(list,thisLesson,startTime,endTime);
    }
}