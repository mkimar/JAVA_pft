package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().groupPage();
    if (app.group().list().size() == 0)  {
      app.group().create(new GroupData().withName("TestNULL"));
    }
  }
  @Test
  public void testGroupDeletion() {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);// сравнение размеров двух списков

    before.remove(index); // перед сравнением удаляется элемент из первоначального списка
    Assert.assertEquals(before, after);// сравнение объектов/списков

  }



}
