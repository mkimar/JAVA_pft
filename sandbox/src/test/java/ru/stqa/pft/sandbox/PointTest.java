package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.PointP1;

/**
 * Created by marina on 26.02.2016.
 */
public class PointTest {

  @Test
  public void testDistance () {

    PointP1 p1 = new PointP1(1, 2, 4, 6);
    Assert.assertEquals(p1.distance(), 5.0);
    
  }

}
