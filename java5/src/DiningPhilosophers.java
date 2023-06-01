public class DiningPhilosophers {
    private static final int NUMBER_OF_PHILOSOPHERS = 5;
    private static final int SIMULATION_TIME = 1000 * 30; // 30 seconds

    public static void main(String[] args) throws InterruptedException {

        Fork[] forks = new Fork[NUMBER_OF_PHILOSOPHERS];
        Philosopher[] philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];

        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            philosophers[i] = new Philosopher(forks[i], forks[(i + 1) % NUMBER_OF_PHILOSOPHERS], i);
            new Thread(philosophers[i]).start();
        }

        Thread.sleep(SIMULATION_TIME);

        for (Philosopher philosopher : philosophers) {
            philosopher.setFull(true);
        }
    }
}

class Philosopher implements Runnable {

    private final Fork leftFork;
    private final Fork rightFork;
    private final int id;
    private boolean isFull = false;

    public Philosopher(Fork leftFork, Fork rightFork, int id) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.id = id;
    }

    public void setFull(boolean isFull) { this.isFull = isFull; }

    public void run() {
        while (!isFull) {
            think();
            synchronized (leftFork) {
                System.out.println("Philosopher " + id + " has picked up left fork.");
                synchronized (rightFork) {
                    System.out.println("Philosopher " + id + " has picked up right fork and is now eating.");
                    eat();
                    System.out.println("Philosopher " + id + " has put down right fork and is now thinking.");
                }
                System.out.println("Philosopher " + id + " has put down left fork.");
            }
        }
    }

    private void think() {
        try {
            System.out.println("Philosopher " + id + " is thinking.");
            Thread.sleep(new java.util.Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        try {
            System.out.println("Philosopher " + id + " is eating.");
            Thread.sleep(new java.util.Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Fork {
    // empty class
}
