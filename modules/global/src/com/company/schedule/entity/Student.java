package com.company.schedule.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Table(name = "SCHEDULE_STUDENT", indexes = {
        @Index(name = "IDX_SCHEDULE_STUDENT_FULL_NAME", columnList = "FULL_NAME")
})
@Entity(name = "schedule_Student")
@NamePattern("%s %s|gradeBook,fullName")
public class Student extends StandardEntity {
    private static final long serialVersionUID = -4868034833358718728L;

    @NotNull
    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @NumberFormat(pattern = "000000")
    @NotNull
    @Column(name = "GRADE_BOOK", nullable = false, unique = true)
    @Positive
    @Max(999999)
    private Integer gradeBook;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GROUP_ID")
    @OnDeleteInverse(DeletePolicy.CASCADE)
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Integer getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(Integer gradeBook) {
        this.gradeBook = gradeBook;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}