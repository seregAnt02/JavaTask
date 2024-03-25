package views;

import models.Order;
import models.Product;
import models.User;
import presenters.Market;

public class ViewMarket {

    public void AddProduct(Product product){
        System.out.println("Добавление продукта -> " + product);
    }

    public void WriteData(String fileName, String typeObject){
        System.out.println("Объекты пользовательских типов ->\r\n" + typeObject + "записаны в файл -> " + fileName);
    }

    public void Holiday(User user){
        System.out.println(user.getName() + " сегодня обычный день " + Market.Holiday.NoHoliday + "!, идем на работу.");
    }

    public void HolidayMale(User user, double totalSum){
        System.out.println( user.getName() + " сегодня " + User.Genus.Male.getType() + " день! " +
                Market.Holiday.MaleDay.getDay() + ", отдыхаем.");
        System.out.println("Общая сумма со скидкой " + totalSum + " руб.");
    }

    public void HolidayFemale(User user, double totalSum){
        System.out.println( user.getName() + " сегодня " + User.Genus.Female.getType() + " день! " +
                Market.Holiday.WomenDay.getDay() + ", отдыхаем.");
        System.out.println("Общая сумма со скидкой " + totalSum + " руб.");
    }

    public  void HolidayNewYear(User user, double totalSum){
        System.out.println( user.getName() + " сегодня новый год! " + Market.Holiday.NewYear.getDay() + ", отдыхаем.");
        //System.out.println("Скидка: ");
        System.out.println("Общая сумма со скидкой " + totalSum + " руб.");
    }

    public void Discount(User user, int discount){
        System.out.println(user.getName() + " скидка " + discount + " %");
    }
}
