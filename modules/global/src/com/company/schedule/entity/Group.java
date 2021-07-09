package com.company.schedule.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Table(name = "SCHEDULE_GROUP")
@Entity(name = "schedule_Group")
@NamePattern("%s|groupNumber")
public class Group extends StandardEntity {
    private static final long serialVersionUID = -2389787330285512191L;

    @NumberFormat(pattern = "0000")
    @NotNull
    @Column(name = "GROUP_NUMBER", nullable = false, unique = true)
    @Max(9999)
    @Positive
    private Integer groupNumber;

    @OrderBy("gradeBook DESC")
    @OneToMany(mappedBy = "group")
    @OnDelete(DeletePolicy.CASCADE)
    private List<Student> students;

    @OneToMany(mappedBy = "group")
    @OnDelete(DeletePolicy.CASCADE)
    private List<Lesson> lessons;

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }
}