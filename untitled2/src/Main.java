import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Программа считывающая
 * @autor Бабаскин Никита
 */
/**
 * Класс, который реализует интерфейс Runnable. Он содержит единственный конструктор Task(int n) для задания номера файла
 */
class Task implements Runnable {
    public int n;

    public Task(int n) {
        this.n = n;
    }

    /**
     * Метод, который будет выполняться в потоке
     * Он считывает данные из файла в формате, заданном в условии задачи, и выполняет над ними заданные операции
     * Результат записывается в выходной файл out.dat
     */
    @Override
    public void run() {
        try {
            File inFile = new File(String.format("in_%d.dat", n));
            Scanner fr = new Scanner(inFile);

            int opType = fr.nextInt();
            fr.nextLine(); // Чтение пустой строки

            List<Double> values = new ArrayList<>();
            String[] numbers = fr.nextLine().split(" ");
            for (String number : numbers) {
                double value = Double.parseDouble(number.replace(",", "."));
                values.add(value);
            }

            double result = 0;
            switch (opType) {
                case 1:
                    result = values.get(0) + values.get(1) + values.get(2) + values.get(3) + values.get(4) + values.get(5) + values.get(6) + values.get(7) + values.get(8) + values.get(9);
                    break;
                case 2:
                    result = values.get(0) * values.get(1) * values.get(2) * values.get(3) * values.get(4) * values.get(5) * values.get(6) * values.get(7) * values.get(8) * values.get(9);
                    break;
                case 3:
                    result = Math.pow(values.get(0), 2) + Math.pow(values.get(1), 2) + Math.pow(values.get(2), 2) + Math.pow(values.get(3), 2) + Math.pow(values.get(4), 2) + Math.pow(values.get(5), 2) + Math.pow(values.get(6), 2) + Math.pow(values.get(7), 2) + Math.pow(values.get(8), 2) + Math.pow(values.get(9), 2);
                    break;
                default:
                    System.out.println("Неверный номер операции");
            }

            System.out.println("Результат для файла in_" + n + ".dat: " + result);

            fr.close();

            synchronized (Task.class) {
                File outFile = new File("out.dat");
                FileWriter fw = new FileWriter(outFile, true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(result);
                pw.close();
            }
        } catch (IOException e) {
            System.out.println(String.format("Error while processing file in_%d.dat: %s", n, e.getMessage()));
        }
    }
}

/**
 * Класс, создающий список потоков, соответствующих задачам
 * Каждому потоку соответствует свой экземпляр класса Task
 * Затем потоки запускаются методом start()
 * После этого вызывается метод join() для каждого потока, чтобы дождаться, пока все потоки завершат свою работу
 * Это необходимо для того, чтобы гарантировать корректное завершение программы.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        double sum = 0;

        for (int i = 1; i < 4; i++) {
            Thread t = new Thread(new Task(i));
            threadList.add(t);
            t.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        try {
            File outFile = new File("out.dat");
            Scanner scanner = new Scanner(outFile);

            while (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error while reading output file: " + e.getMessage());
        }

        System.out.println("Сумма результатов: " + sum);

    }
}