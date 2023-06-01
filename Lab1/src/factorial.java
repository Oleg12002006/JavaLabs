/**
 * Программа для вычисления факториала числа.
 * Факториал числа - произведение всех натуральных чисел от 1 до этого числа включительно.
 */
public class factorial {
    /**
     * Метод для вычисления факториала числа.
     * @param n число, факториал которого нужно вычислить
     * @return факториал числа n
     */
    static int calculateFactorial(int n){
        int result = 1;
        for (int i = 1; i <= n; i++){
            result *= i; // произведение всех натуральных чисел от 1 до n включительно
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(calculateFactorial(4)); // пример вычисления факториала числа 4
    }
}