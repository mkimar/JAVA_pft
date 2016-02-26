package ru.stga.pft.sandbox;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by marina on 23.02.2016.
 */
public class Point {

  public static void main(String[] args) {

    // Вывод на печать приветствие
    hello("Архат");
    hello("Арман");
    hello("Коллеги");

    // Объявление объекта PointP1. В данном объекте описаны точки и их координаты.

    PointP1 p1 = new PointP1(1, 2, 4, 6);



    // Вывод на печать результат вычисления расстояния между двумя точками А (х1,y1)и B (x2,y2)

    System.out.println("Расстояние между двумя точками А с координатами (" + p1.x1 + ";" + p1.y1 + ")" +
            " и " + "B с координатами (" + p1.x2 + ";" + p1.y2 + ")" + " равна " + p1.distance());

  }

  public static void hello(String somebady) {

    System.out.println("Hello," + somebady + "!!!");
  }


}
