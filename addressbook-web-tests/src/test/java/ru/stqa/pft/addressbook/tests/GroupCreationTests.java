package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupsHelper().initGroupCreation();
        app.getGroupsHelper().fillGroupForm(new GroupData("MIR123", "Testas_02", "Testas_03"));
        app.getGroupsHelper().submitGroupCreation();
        app.getGroupsHelper().returnToGroupPage();
        app.getSessionHelper().logout();


    }

}
