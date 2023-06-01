import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
/**
 * Программа определяет склонение слова "год" в зависимости от возраста.
 * Возраст вводится пользователем с клавиатуры.
 * @autor Олег Потёмкин
 */
public class fifth {
    private static final Logger logger = LogManager.getLogger(fifth.class);
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /* Вводим возраст */
        logger.info("Введите возраст (от 0 до 99 лет): ");
        int age = in.nextInt();
        String ageString;
        if (age >= 0 && age <= 99) { // проверяем корректность введенного возраста
            if (age == 0 || age >= 5 && age <= 20 || age % 10 >= 5 && age % 10 <= 9 || age % 10 == 0) {
                ageString = "лет";
            } else if (age == 1 || age % 10 == 1) {
                ageString = "год";
            } else {
                ageString = "года";
            }
            logger.info("Вам " + age + " " + ageString);
        } else {
            logger.error("Возраст должен быть от 0 до 99 лет");
        }
    }
}