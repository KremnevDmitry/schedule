package com.company.schedule.service;

import com.company.schedule.entity.Classroom;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ClassroomService {
    String NAME = "schedule_ClassroomService";

    public boolean isClassroomFree (Classroom classroom, LocalDate day, LocalTime startTime, LocalTime endTime);

    public boolean isAvailableSize(Classroom classroom, int numberOfGroups);

}