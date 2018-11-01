public class DinningPhilospher{

    public static void main(String[] args) throws Exception {

        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[5];

        for (int counter = 0; counter < forks.length; counter++) {
            forks[counter] = new Object();
        }

        for (int counter = 0; counter < philosophers.length; counter++) {
            Object leftFork = forks[counter];
            Object rightFork = forks[(counter + 1) % forks.length];

            philosophers[counter] = new Philosopher(forks[counter], forks[(counter + 1) % 5]);

            Thread philosophersTeam
              = new Thread(philosophers[counter], "Philosopher " + (counter + 1));
            philosophersTeam.start();
        }
    }
}