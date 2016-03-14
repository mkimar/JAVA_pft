package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupsHelper().creatGroup(new GroupData("TestNULL", "rewa14032016", "rewa2"));
    app.getSessionHelper().logout();


  }

}
