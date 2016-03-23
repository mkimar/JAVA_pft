package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test

  public void testGroupModification() {

    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().creatGroup(new GroupData("Test01", "rewa14032016", "rewa2"));
    }
    List<GroupData> before = app.getGroupsHelper().getGroupList();
    app.getGroupsHelper().selectGroup(before.size() - 1);//выбор послед.группы для модификации
    app.getGroupsHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(),"TestNULL02", null, "as_03");
    app.getGroupsHelper().fillGroupForm(group);
    app.getGroupsHelper().submitGroupModification();
    app.getGroupsHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupsHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
