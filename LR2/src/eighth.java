import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Программа находит сумму всех n-значных чисел, кратных k (1<=n<4=).
 * n вводится пользователем с клавиатуры.
 *
 * @autor Олег Потёмкин
 */
public class eighth {
    private static final Logger LOGGER = Logger.getLogger(eighth.class.getName());

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LOGGER.info("Введите n: ");
        int n = in.nextInt();

        if (n < 1 || n > 4) {
            LOGGER.warning("Некорректное значение n: " + n);
            System.out.println("Введите n от 1 до 4");
        } else {
            LOGGER.info("Введите k: ");
            int k = in.nextInt();

            int sum = 0;
            for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++) {
                if (i % k == 0) {
                    sum += i;
                }
            }

            LOGGER.info("Сумма чисел: " + sum);
        }
    }
}