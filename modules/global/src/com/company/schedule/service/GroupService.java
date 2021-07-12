package com.company.schedule.service;

import com.company.schedule.entity.Group;

import java.time.LocalDate;
import java.time.LocalTime;

public interface GroupService {
    String NAME = "schedule_GroupService";

    public boolean isFree(Group groupNumber, LocalDate day, LocalTime startTime, LocalTime endTime);
}