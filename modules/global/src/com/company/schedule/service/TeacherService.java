package com.company.schedule.service;

import com.company.schedule.entity.Lesson;

import java.time.LocalDate;
import java.time.LocalTime;

public interface TeacherService {
    String NAME = "schedule_TeacherService";

    public boolean isFree(Lesson thisLesson, String email, LocalDate day, LocalTime startTime, LocalTime endTime);
}