package ru.stga.pft.sandbox;

/**
 * Created by marina on 23.02.2016.
 */
public class MytestPoint {

  public static void main(String[] args) {
    hello("Архат");
    hello("Арман");
    hello("Коллеги");

    double x1 = 1;
    double x2 = 4;
    double y1 = 2;
    double y2 = 6;

    System.out.println("Расстояние между двумя точками А с координатами (" + x1 + " ; " + y1 + ")" +
            " и " + "B с координатами (" + x2 + ";" + y2 + ")" + " равна " + squareRoot(x1, x2, y1, y2));

  }

  public static void hello(String somebady) {

    System.out.println("Hello," + somebady + "!!!");
  }


  public static double squareRoot(double x1, double x2, double y1, double y2) {

    return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);


  }




}
