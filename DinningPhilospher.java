public class DinningPhilospher{
 
    public static void main(String[] args) throws Exception {
 	
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[5];
 
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }
 
        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];
 
            philosophers[i] = new Philosopher(forks[i], forks[(i + 1) % 5]);
             
            Thread t 
              = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}