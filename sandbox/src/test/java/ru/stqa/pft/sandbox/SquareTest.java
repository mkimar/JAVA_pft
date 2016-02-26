package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;
import ru.stga.pft.sandbox.Square;

/**
 * Created by marina on 26.02.2016.
 */
public class SquareTest {

@Test
  public void testArea () {

    Square s = new Square(7);
    assert s.area () == 49;
  }


}
