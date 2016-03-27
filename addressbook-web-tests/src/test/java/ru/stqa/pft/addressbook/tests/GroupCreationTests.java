package ru.stqa.pft.addressbook.tests;

import com.beust.jcommander.Parameter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new GroupData().withName("TEST NULL").withHeader("header").withFooter("footer")});
    list.add(new Object[]{new GroupData().withName("TEST NULL01").withHeader("header01").withFooter("footer01")});
    list.add(new Object[]{new GroupData().withName("TEST NULL02").withHeader("header02").withFooter("footer03")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
    app.getNavigationHelper().groupPage();
    Groups before = app.group().all();
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
