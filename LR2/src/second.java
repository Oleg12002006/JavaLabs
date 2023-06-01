import java.util.Scanner;
import org.apache.logging.log4j.*;
/**
 * Программа находит площадь кольца, внутренний радиус которого равен r, а внешний — заданному числу R (R > r).
 * Значение переменных R и r вводятся пользователем с клавиатуры.
 * @autor Олег Потёмкин
 */
public class second {
    final static Logger LOG = LogManager.getLogger(second.class);

    public static void main(String[] args) {
        double s;
        Scanner in = new Scanner(System.in);
        LOG.info("Начало работы программы");
        System.out.print("Введите R: ");
        int R = in.nextInt();
        LOG.info("Пользователь ввел R = " + R);
        System.out.print("Введите r: ");
        int r = in.nextInt();
        LOG.info("Пользователь ввел r = " + r);
        if (R>r) {
            s = Math.PI * Math.pow(R, 2) - Math.PI * Math.pow(r, 2);
            LOG.info("Вычислена площадь кольца: " + s);
            System.out.println("Площадь кольца равна " + s);
        } else {
            LOG.warn("Введенные значения не соответствуют условиям задачи");
            System.out.println("Ошибка: R должен быть больше r");
        }
        LOG.info("Завершение работы программы");
    }
}