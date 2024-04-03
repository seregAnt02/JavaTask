package task1;

/*Описать интерфейс Person с методами doWork() и haveRest().
Написать два класса работник и бездельник, реализующих интерфейс.
Работник работает, и не умеет бездельничать, в то время как бездельник не умеет работать, но умеет отдыхать.
Написать обобщённые классы Workplace и Club, содержащие массив из Person. В классах необходимо
вызывать у всего массива людей вызывать соответствующие методы
 */

/*Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким образом,
        чтобы итератор был внутренним классом и, соответственно, объектом в коллекции.*/


public class App {
    public static void main(String[] args) {
        Person[] persons = {new Worker("Ivan"), new Idle("Tom"),
                new Worker("Bob"), new Worker("Jim")};
        Workplace<Person> workplace = new Workplace<>(persons);
        Club<Person> club = new Club<>(persons);
        workplace.start();
        club.start();

        workplace.showCollection();
        club.showCollection();
    }
}
