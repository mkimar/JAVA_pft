package ru.stga.pft.sandbox;

public class Mytest {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Marina");


    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + area(s));

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + area(r));

  }


  public static void hello(String somebady) {

    System.out.println("Hello," + somebady + "!!!");
  }

  public static double area(Square s) {
    return s.l * s.l;
  }

  public static double area(Rectangle r) {
    return r.a * r.b;
  }

}

