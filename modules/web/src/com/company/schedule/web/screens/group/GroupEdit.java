package com.company.schedule.web.screens.group;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Group;

@UiController("schedule_Group.edit")
@UiDescriptor("group-edit.xml")
@EditedEntityContainer("groupDc")
@LoadDataBeforeShow
public class GroupEdit extends StandardEditor<Group> {
}