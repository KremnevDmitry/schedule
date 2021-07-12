package com.company.schedule.service;

import java.time.LocalDate;
import java.time.LocalTime;

public interface TeacherService {
    String NAME = "schedule_TeacherService";

    public boolean isFree(String email, LocalDate day, LocalTime startTime, LocalTime endTime);
}