package com.company.schedule.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "SCHEDULE_TEACHER")
@Entity(name = "schedule_Teacher")
@NamePattern("%s|fullName")
public class Teacher extends StandardEntity {
    private static final long serialVersionUID = -6541421753923450989L;

    @NotNull
    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "EMAIL", nullable = false, unique = true)
    @Email
    @NotNull
    private String email;

    @OneToMany(mappedBy = "teacher")
    @OnDelete(DeletePolicy.CASCADE)
    private List<Lesson> lessons;

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}