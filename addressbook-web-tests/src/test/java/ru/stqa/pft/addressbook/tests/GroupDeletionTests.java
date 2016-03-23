package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().groupPage();
    if (app.group().all().size() == 0)  {
      app.group().create(new GroupData().withName("TestNULL"));
    }
  }
  @Test
  public void testGroupDeletion() {
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() - 1);// сравнение размеров двух списков

    before.remove(deletedGroup); // перед сравнением удаляется элемент из первоначального списка
    Assert.assertEquals(before, after);// сравнение объектов/списков

  }



}
