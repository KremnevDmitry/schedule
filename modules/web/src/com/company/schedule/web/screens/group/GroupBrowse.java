package com.company.schedule.web.screens.group;

import com.haulmont.cuba.gui.screen.*;
import com.company.schedule.entity.Group;

@UiController("schedule_Group.browse")
@UiDescriptor("group-browse.xml")
@LookupComponent("groupsTable")
@LoadDataBeforeShow
public class GroupBrowse extends StandardLookup<Group> {
}