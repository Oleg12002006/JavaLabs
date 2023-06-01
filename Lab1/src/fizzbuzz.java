/**
 * Программа, которая выводит числа от 1 до 500 включительно.
 * Если число кратно 3, выводится "buzz",
 * если число кратно 5, выводится "fizz",
 * если число кратно и 3, и 5, выводится "fizzbuzz".
 */
public class fizzbuzz {

    public static void main(String[] args) {
        int i = 1;
        while (i++ <= 500) { // выводим числа от 1 до 500
            if (((i % 3) == 0) && ((i % 5) == 0))
                System.out.println("fizzbuzz");
            else if ((i % 5) == 0)
                System.out.println("fizz");
            else if ((i % 3) == 0)
                System.out.println("buzz");
            else
                System.out.println(i);
        }
    }
}
