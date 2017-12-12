
public class Timer implements Runnable{
	
	private int number;
	
	public Timer (int number) {
		this.number = number;
	}
	
	public void run() {
		for ( int i = 1; i <= number; i++ ) {
			System.out.println(" " +i);
		}
	}

}
