import java.util.Scanner;
import org.apache.logging.log4j.*;
/**
 * Программа определяет является ли треугольник со сторонами a, b, с равнобедренным.
 * Сторона a, b, c вводятся пользователем с клавиатуры.
 * @autor Олег Потёмкин
 */
public class third {
    final static Logger logger = LogManager.getLogger(third.class);

    public static void main(String[] args) {
        double s;
        Scanner in = new Scanner(System.in);
        logger.info("Начало работы программы");
        System.out.print("Введите a: ");
        int a = in.nextInt();
        logger.info("Пользователь ввел a = " + a);
        System.out.print("Введите b: ");
        int b = in.nextInt();
        logger.info("Пользователь ввел b = " + b);
        System.out.print("Введите c: ");
        int c = in.nextInt();
        logger.info("Пользователь ввел c = " + c);

        if (a==b || a==c || c==b){
            logger.info("Вычислен результат: треугольник равнобедренный");
            System.out.println("Треугольник равнобедренный");
        } else {
            logger.info("Вычислен результат: треугольник не равнобедренный");
        }

        logger.info("Завершение работы программы");
    }
}