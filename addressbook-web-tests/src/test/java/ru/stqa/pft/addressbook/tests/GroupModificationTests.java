package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("Test01"));
    }
  }

  @Test

  public void testGroupModification() {

    Set<GroupData> before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("TestNULL02").withHeader("as_03").withFooter("test3");
    app.group().modify(group);//модификация группы
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(before, after);

  }



}
