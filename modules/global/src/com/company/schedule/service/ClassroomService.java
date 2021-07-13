package com.company.schedule.service;

import com.company.schedule.entity.Classroom;
import com.company.schedule.entity.Lesson;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ClassroomService {
    String NAME = "schedule_ClassroomService";

    public boolean isClassroomFree (Lesson thisLesson, Classroom classroom, LocalDate day, LocalTime startTime, LocalTime endTime);

    public boolean isAvailableSize(Classroom classroom, int numberOfGroups);

}