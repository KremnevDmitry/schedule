package com.company.schedule.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum ClassroomType implements EnumClass<Integer> {

    LECTURE(0),
    LABORATORY(1);

    private Integer id;

    ClassroomType(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static ClassroomType fromId(Integer id) {
        for (ClassroomType at : ClassroomType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}