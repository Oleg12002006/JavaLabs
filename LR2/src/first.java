import java.util.Scanner;
import org.apache.logging.log4j.*;
/**
 * Программа для вычисления значения функции f(x) = (x^2 - 7x + 10) / (x^2 - 8x + 12).
 * Значение переменной x вводится пользователем с клавиатуры.
 * @autor Олег Потёмкин
 */
public class first {
    private static final Logger LOG = LogManager.getLogger(first.class);
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LOG.info("Program started");

        /** Вводим значение переменной х */
        System.out.print("Введите значение x: ");
        int x = in.nextInt();
        LOG.debug("Variable x = {}", x);

        double f;
        f = (Math.pow(x,2) - 7 * x + 10) / (Math.pow(x,2) - 8 * x + 12);
        LOG.debug("Calculated f = {}", f);

        System.out.println("f(" + x + ") = " + f);
        LOG.info("Program finished");
    }
}