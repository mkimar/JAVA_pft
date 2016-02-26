package ru.stga.pft.sandbox;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by marina on 23.02.2016.
 */
// Создание объекта PointP1 с атрибутами x1, y1, x2, y2.
public class PointP1 {

  public double x1;
  public double y1;
  public double x2;
  public double y2;

  public PointP1(double x1, double y1, double x2, double y2) {

    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;

  }

  // Метод вычисления расстояния между двумя точками на плоскости.

  public double distance() {

    return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));

  }

}
