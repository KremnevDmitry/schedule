package com.company.schedule.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Table(name = "SCHEDULE_LESSON")
@Entity(name = "schedule_Lesson")
public class Lesson extends StandardEntity {
    private static final long serialVersionUID = -2195745314940404507L;

    @NotNull
    @Column(name = "DAY_", nullable = false)
    private LocalDate day;

    @NotNull
    @Column(name = "TIME_", nullable = false)
    private LocalTime time;

    @NotNull
    @Column(name = "DURATION", nullable = false)
    private LocalTime duration;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TEACHER_ID")
    @OnDeleteInverse(DeletePolicy.CASCADE)
    private Teacher teacher;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToMany
    @JoinTable(name = "SCHEDULE_LESSON_GROUP_LINK",
            joinColumns = @JoinColumn(name = "LESSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "GROUP_ID"))
    private List<Group> group;

    @NotNull
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CLASSROOM_ID")
    private Classroom classroom;

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }

    public List<Group> getGroup() {
        return group;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    @MetaProperty(related = {"time", "duration"})
    public LocalTime getEndTime() {
        return (time != null && duration != null) ? time.plusHours(duration.getHour()).plusMinutes(duration.getMinute()) : null;
    }
}