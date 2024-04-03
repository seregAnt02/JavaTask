
/*Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
        sum(), multiply(), divide(), subtract(). Параметры этих методов – два
        числа разного типа, над которыми должна быть произведена операция.*/

package task2;

public class App {

    public static void main(String[] args) {
        Number result;
        result = Calculator.sum(Integer.valueOf(15), Float.valueOf(29.159f));
        System.out.printf("Integer 15 + Float 29.159f = %s as Float\n", result.floatValue());
        result = Calculator.divide(Double.valueOf(123.456789), Long.valueOf(24));
        System.out.printf("Double 123.456789 / Long 24 = %s as Double\n", result.doubleValue());
        System.out.printf("Double 123.456789 / Long 24 = %s as Long\n", result.longValue());
        result = Calculator.multiply(Byte.valueOf((byte) 11), Short.valueOf((short) 32000));
        System.out.printf("Byte 11 * Short 32000 = %s as Integer\n", result.intValue());
        result = Calculator.subtract(Short.valueOf((short) 789), Double.valueOf(1000.4837));
        System.out.printf("Short 789 - Double 1000.4837 = %s as Double\n", result.doubleValue());
        System.out.printf("Short 789 - Double 1000.4837 = %s as Integer\n", result.intValue());
    }
}
