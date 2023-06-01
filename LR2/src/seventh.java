import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Программа для вычисления суммы ряда функции f(x) = x + (x^2)/2 + (x^3)/3 + ... + (x^n)/n,
 * где x - вещественное число, n - число слагаемых в ряду.
 * Значения x и n вводятся пользователем с клавиатуры.
 */
public class seventh {
    private static final Logger LOGGER = Logger.getLogger(seventh.class.getName());

    public static void main(String[] args) {
        double x, s = 1, c;
        int n;
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Введите значение x:");
        System.out.print("x = ");
        x = sc.nextDouble();
        LOGGER.info("Введите число слагаемых в ряду:");
        System.out.print("n = ");
        n = sc.nextInt();
        for (int i = 2; i <= n; i++) { // начинаем с i = 2, так как первый член ряда равен x
            c = Math.pow(x, i) / i;  // значение текущего члена прогрессии
            s += c; // прибавляем текущий член прогрессии к сумме
        }

        LOGGER.info("Сумма ряда: " + String.format("%.3f", s));
        sc.close();
    }
}