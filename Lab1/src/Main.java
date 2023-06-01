import java.util.Scanner;

/**
 * Программа для поиска наименьшего из трех введенных чисел.
 */
public class MinFinder {
    public static void main (String[] args){
        System.out.println("Введите число 1: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Введите число 2: ");
        int b = sc.nextInt();
        System.out.println("Введите число 3: ");
        int c = sc.nextInt();
        if ((a < b) && (a < c))
            System.out.println("Min = " + a);
        else if ((b < a) && (b < c))
            System.out.println("Min = " + b);
        else
            System.out.println("Min = " + c);
    }
}