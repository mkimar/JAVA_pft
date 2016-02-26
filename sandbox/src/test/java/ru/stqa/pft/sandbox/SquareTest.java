package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.Square;

/**
 * Created by marina on 26.02.2016.
 */
public class SquareTest {

@Test
  public void testArea () {

    Square s = new Square(7);
    Assert.assertEquals(s.area (),49.0);
  }


}
