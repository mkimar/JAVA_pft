package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Testas_01", "Testas_02", "Testas_03"));
        submitGroupCreation();
        returnToGroupPage();
        logout();

    }

}
