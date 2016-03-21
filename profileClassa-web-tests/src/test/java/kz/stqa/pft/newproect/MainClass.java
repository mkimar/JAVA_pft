package kz.stqa.pft.newproect;


import org.testng.TestNG;

public class MainClass {

  public static void main(String[] args) {
    final TestNG testNG = new TestNG(true);
    testNG.setTestClasses(new Class[]{ClassAnalyzeTests.class});
    testNG.setExcludedGroups("optional");
    testNG.run();

  }
}

