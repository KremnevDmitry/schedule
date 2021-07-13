package com.company.schedule.service;

import com.company.schedule.entity.Group;
import com.company.schedule.entity.Lesson;

import java.time.LocalDate;
import java.time.LocalTime;

public interface GroupService {
    String NAME = "schedule_GroupService";

    public boolean isFree(Lesson thisLesson, Group groupNumber, LocalDate day, LocalTime startTime, LocalTime endTime);
}