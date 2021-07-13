package com.company.schedule.service;

import com.company.schedule.entity.Lesson;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service(TimeIntersectionService.NAME)
public class TimeIntersectionServiceBean implements TimeIntersectionService {

    @Override
    public boolean isIntersection(List<Lesson> list, Lesson thisLesson, LocalTime startTime, LocalTime endTime) {
        for (Lesson lesson: list){
            if(thisLesson != null)
                if (lesson.equals(thisLesson))
                    continue;
            if ((lesson.getTime().isBefore(endTime) && lesson.getEndTime().isAfter(startTime) ||
                    lesson.getEndTime().isBefore(endTime) && lesson.getEndTime().isAfter(startTime) ||
                    lesson.getEndTime().isBefore(endTime) && lesson.getTime().isAfter(startTime) ||
                    lesson.getTime().isBefore(startTime) && lesson.getEndTime().isAfter(endTime)))
                return false;
        }
        return true;
    }
}