import java.util.Random;

public class Warcraft {
    public static int goldMine = 100; // изначальное количество золота в шахте

    public static void main(String[] args) throws InterruptedException {
        int numOfUnits = 5;  // количество юнитов
        Thread[] threads = new Thread[numOfUnits];  // массив потоков для каждого юнита

        for (int i = 0; i < numOfUnits; i++) {
            threads[i] = new Thread(new Unit(i));  // создаем новый поток для каждого юнита
            threads[i].start();  // запускаем поток
        }

        for (Thread thread : threads) {
            thread.join();  // ждем, пока все потоки завершат работу
        }

        System.out.println("Шахта исчерпана. Золота осталось: " + goldMine);
    }
}

class Unit implements Runnable {
    private int id;
    private Random rand = new Random();

    public Unit(int id) {
        this.id = id;  // идентификатор юнита
    }

    @Override
    public void run() {
        while (Warcraft.goldMine > 0) {  // добываем золото, пока оно есть в шахте
            int goldPortion = Math.min(10, Warcraft.goldMine);  // добываем порцию золота (не более 10 единиц)
            Warcraft.goldMine -= goldPortion;  // уменьшаем количество золота в шахте
            System.out.println("Юнит " + id + " добывает " + goldPortion + " золота. Золота осталось: " + Warcraft.goldMine);

            try {
                int delay = rand.nextInt(1000) + 500;  // случайная задержка от 0.5 до 1.5 секунд
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}