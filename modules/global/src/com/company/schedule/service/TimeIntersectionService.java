package com.company.schedule.service;

import com.company.schedule.entity.Lesson;

import java.time.LocalTime;
import java.util.List;

public interface TimeIntersectionService {
    String NAME = "schedule_TimeIntersectionService";
    public boolean isIntersection(List<Lesson> list, Lesson thisLesson, LocalTime startTime, LocalTime endTime);
}