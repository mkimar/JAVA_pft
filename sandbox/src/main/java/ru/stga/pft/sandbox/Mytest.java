package ru.stga.pft.sandbox;

public class Mytest {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Marina");

    double l = 5;
    System.out.println("Площадь квадрата со стороной " + l + " равна " + area(l));

    double a = 4;
    double b = 6;
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " равна " + area(a, b));

  }


  public static void hello(String somebady) {

    System.out.println("Hello," + somebady + "!!!");
  }

  public static double area(double len) {
    return len * len;
  }

  public static double area(double a, double b) {
    return a * b;
  }

}

