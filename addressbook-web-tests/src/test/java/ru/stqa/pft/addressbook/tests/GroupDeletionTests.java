package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().groups().size() == 0) {
      app.getNavigationHelper().groupPage();
      app.group().create(new GroupData().withName("TestNULL"));
    }

  }
  @Test
  public void testGroupDeletion() {
    Groups before = app.db().groups();
    app.getNavigationHelper().groupPage();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.db().groups();
    assertThat(after.size(), equalTo(before.size() - 1));// сравнение размеров двух списков
    assertThat(after, equalTo(before.withOut(deletedGroup)));// сравнение объектов/списков
    verifyGroupListInUI();// отключено сравнение списка групп из базы данных со списком групп в интерфейсе
    // , для включения необходимо изменить параметр
  }



}
