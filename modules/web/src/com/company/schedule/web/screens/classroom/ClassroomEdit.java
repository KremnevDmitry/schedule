package com.company.schedule.web.screens.classroom;

import com.company.schedule.entity.ClassroomType;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Classroom;

import javax.inject.Inject;

@UiController("schedule_Classroom.edit")
@UiDescriptor("classroom-edit.xml")
@EditedEntityContainer("classroomDc")
@LoadDataBeforeShow
public class ClassroomEdit extends StandardEditor<Classroom> {
    @Inject
    private LookupField<ClassroomType> typeField;
    @Inject
    private TextField<Integer> sizeField;

    @Subscribe("typeField")
    public void onTypeFieldValueChange(HasValue.ValueChangeEvent<ClassroomType> event) {
        if (typeField.getValue() != null) {
            if (typeField.getValue().getId().equals(1)) {
                sizeField.setValue(1);
                sizeField.setEditable(false);
            } else {
                sizeField.setEditable(true);
            }
        }
    }
}