package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().creatGroup(new GroupData("TestNULL", "rewa14032016", "rewa2"));
    }
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    app.getGroupsHelper().selectGroup(before.size() - 1);
    app.getGroupsHelper().deleteGroup();
    GroupData group = new GroupData("TestNULL", null, "as_03");
    app.getGroupsHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupsHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);// сравнение размеров двух списков

    before.remove(before.size()-1); // перед сравнением удаляется элемент из первоначального списка
    Assert.assertEquals(before, after);// сравнение объектов/списков

  }


}
