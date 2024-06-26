/*
Задача 1: Реализация интерфейсов и множественное наследование
Создайте два интерфейса: Runnable и Eater. В Runnable определите метод run(), в Eater — eat().
        Создайте класс Animal, который реализует оба интерфейса.
        Реализуйте методы run() и eat() в классе Animal.*/


/*Задача 2: Использование методов по умолчанию в интерфейсах
        Цель: Изучить использование методов по умолчанию в интерфейсах.

        Добавьте метод по умолчанию sleep() в интерфейс Eater.
        Создайте экземпляр класса Animal и вызовите метод sleep().
        Обратите внимание на то, что класс Animal не нужно модифицировать.*/

package task1_2;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.sleep();
    }
}
