
public class Printer implements Runnable{
	private int time ;
	private String url;

	public Printer(String url, int time) {
	this.url = url;
	this.time = time;
	
}

	public void run() {
		for(int i = 1; i <= time; i++) {
			System.out.println();
			WebCrawlerMain.crawler(url);
			try {
				Thread.sleep(300);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
