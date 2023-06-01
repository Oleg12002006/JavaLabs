/**
 * <h1> Числа</h1>
 * Даны целые числа K, N, а также K наборов целых чисел по N
 * элементов в каждом наборе. Найти количество наборов, содержащих число 2.
 * Если таких наборов нет, то вывести 0.
 * <p>
 * @ автор Потёмкин Олег
 * @ от 18.02.2023
 */
import java.util.Scanner;
public class chisla {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        // вводим количество наборов
        System.out.println("k: ");
        int k = in.nextInt();
        // вводм количесво элементов
        System.out.println("n: ");
        int n = in.nextInt();
        int ki,ni,s=0,f=0;
        for (ki=1; ki<=k; ++ki){
            for (ni=1; ni<=n; ++ni){
                System.out.println("Введите " + ni + " число из " + ki + " набора: ");
                int a = in.nextInt();
                if ((a == 2))
                    f=1;
            }
            s+=f;
    }
        if (s > 0){
        System.out.println("Количество наборов, содержащих число 2 = "+ s);}
        else
            System.out.println(0);
}
}
