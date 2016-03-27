package ru.stqa.pft.addressbook.tests;


import com.beust.jcommander.Parameter;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {



  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("TestNULL").withHeader("test505");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));//проверялка


  }

  @Test // негативный тест
  public void testBadGroupCreation() {
    app.getNavigationHelper().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("TestNULL'").withHeader("test505");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));//проверялка


  }


}
