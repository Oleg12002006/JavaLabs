/**
 * Программа, выводящая символы строки "Hello world" в обратном порядке.
 * Символы строки хранятся в массиве типа char.
 */
public class stroka {
    public static void main(String[] args) {
        int i;
        String string = "Hello world";
        char[] result = string.toCharArray(); // преобразуем строку в массив символов
        for (i = 10; i >= 0; i--)
            System.out.println(result[i]); // выводим символы в обратном порядке
    }
}