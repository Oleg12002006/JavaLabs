import java.util.Scanner;
/**
 * Дано натуральное число n. Программа проверяет будут ли все цифры различными
 * Число вводится пользователем с клавиатуры.
 * @autor Олег Потёмкин
 */
public class sixth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int c0 = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0, c9 = 0, n;
        n = input.nextInt();
        while (n != 0) {
            int c = n % 10;
            if (c == 0)
                c0 += 1;
            if (c == 1)
                c1 += 1;
            if (c == 2)
                c2 += 1;
            if (c == 3)
                c3 += 1;
            if (c == 4)
                c4 += 1;
            if (c == 5)
                c5 += 1;
            if (c == 6)
                c6 += 1;
            if (c == 7)
                c7 += 1;
            if (c == 8)
                c8 += 1;
            if (c == 9)
                c9 += 1;
            n /= 10;
        }
        if (c0 > 1 || c1 > 1 || c2 > 1 || c3 > 1 || c4 > 1 || c5 > 1 || c6 > 1 || c7 > 1 || c8 > 1 || c9 > 1)
            System.out.println("В числе не все цифры разные");
        else
            System.out.println("В числе все цифры разные");
        input.close();
    }
}