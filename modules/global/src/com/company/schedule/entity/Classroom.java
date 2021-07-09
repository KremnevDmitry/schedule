package com.company.schedule.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Table(name = "SCHEDULE_CLASSROOM")
@Entity(name = "schedule_Classroom")
@NamePattern("%s|number")
public class Classroom extends StandardEntity {
    private static final long serialVersionUID = -1337268569439385597L;

    @NotNull
    @Column(name = "TYPE_", nullable = false)
    private Integer type;

    @NumberFormat(pattern = "000")
    @NotNull
    @Column(name = "NUMBER_", nullable = false, unique = true)
    @Positive
    @Max(999)
    private Integer number;

    @NumberFormat(pattern = "0")
    @NotNull
    @Column(name = "SIZE_", nullable = false)
    @Min(1)
    @Max(6)
    @Positive
    private Integer size;

    public void setType(ClassroomType type) {
        this.type = type == null ? null : type.getId();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public ClassroomType getType() {
        return type == null ? null : ClassroomType.fromId(type);
    }
}