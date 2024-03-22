package views;

import models.User;
import presenters.Market;

public class ViewMarket {
    public void viewHoliday(){
        System.out.println("Сегодня обычный день " + Market.Holiday.NoHoliday + "!, идем на работу.");
    }

    public void viewHolidayMale(double totalSum){
        System.out.println("Сегодня " + User.Genus.Male.getType() + " день! " +
                Market.Holiday.MaleDay.getDay() + ", отдыхаем.");
        System.out.println("Общая сумма со скидкой " + totalSum + " руб.");
    }

    public void viewHolidayFemale(double totalSum){
        System.out.println("Сегодня " + User.Genus.Female.getType() + " день! " +
                Market.Holiday.WomenDay.getDay() + ", отдыхаем.");
        System.out.println("Общая сумма со скидкой " + totalSum + " руб.");
    }

    public  void viewHolidayNewYear(double totalSum){
        System.out.println("Сегодня новый год! " + Market.Holiday.NewYear.getDay() + ", отдыхаем.");
        //System.out.println("Скидка: ");
        System.out.println("Общая сумма со скидкой " + totalSum + " руб.");
    }

    public void viewDiscount(int discount){
        System.out.println("Скидка " + discount + " %");
    }
}
