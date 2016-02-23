package ru.stga.pft.sandbox;

public class Mytest {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Marina");


    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.area());

  }


  public static void hello(String somebady) {

    System.out.println("Hello," + somebady + "!!!");
  }


}

