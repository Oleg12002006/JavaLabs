import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
/**
 * Известно, что из четырех чисел а1, а2, а3 и а4 одно отлично от трех других, равных между собой;
 * Программа присваивает номер лишнего числа переменной n.
 * Числа а1, а2, а3 и а4 вводятся пользователем с клавиатуры.
 * @autor Олег Потёмкин
 */
public class fourth {
    final static Logger logger = LogManager.getLogger(fourth.class);

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        logger.info("Начало работы программы");

        System.out.print("Введите a1: ");
        int a1 = in.nextInt();
        logger.info("Пользователь ввел a1 = " + a1);

        System.out.print("Введите а2: ");
        int a2 = in.nextInt();
        logger.info("Пользователь ввел a2 = " + a2);

        System.out.print("Введите а3: ");
        int a3 = in.nextInt();
        logger.info("Пользователь ввел a3 = " + a3);

        System.out.print("Введите а4: ");
        int a4 = in.nextInt();
        logger.info("Пользователь ввел a4 = " + a4);

        if (a1==a4){
            if (a1==a2){
                n=3;
            } else {
                n=2;
            }
        } else if (a1==a2){
            n=4;
        } else {
            n=1;
        }

        logger.info("Вычислен номер лишнего числа: " + n);
        System.out.println("Номер лишнего числа "+n);

        logger.info("Завершение работы программы");
    }
}