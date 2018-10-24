
public class Philosopher implements Runnable{
	Object left_fork, right_fork;
	
	public Philosopher(Object left_fork, Object right_fork) {
		this.left_fork = left_fork;
		this.right_fork = right_fork;
	}
	
	public void run(){
			try {
				while (true) {
	                 
	                // thinking
					philospherStatus(" Thinking");
	                synchronized (left_fork) {
	                	philospherStatus("Picked up left fork");
	                    synchronized (right_fork) {
	                        // eating
	                    	philospherStatus("Picked up right fork - eating"); 
	                         
	                    	philospherStatus(" Put down right fork");
	                    }
	                     
	                    // Back to thinking
	                    philospherStatus(" Put down left fork. Back to thinking");
	                }
            }
        } 
		catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
	
	
	private void philospherStatus(String action) throws InterruptedException {
        System.out.println(
          Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) Math.random() * (100)));
    }
	
	
}