import java.util.Scanner;
import java.util.ArrayList;

public class WebCrawlerMain {


	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("Enter a URL: ");
		String url = input.nextLine();
		
		Runnable p = new Printer(url, 2);
		Thread t = new Thread(p);
		t.start();
			
			
	}
	
	public static   void crawler(String startingUrl) {
		ArrayList<String> pendingUrl = new ArrayList<>();
		ArrayList<String> traversedUrl = new ArrayList<>();
		
		pendingUrl.add(startingUrl);
		
		
		
		while (!pendingUrl.isEmpty() && traversedUrl.size() <= 100) {
			String urlString = pendingUrl.remove(0);
			if (!traversedUrl.contains(urlString)) {
				traversedUrl.add(urlString);
				System.out.println("Craw " + urlString);
				
				for (String s: getSubURLs(urlString)) {
					if (!traversedUrl.contains(s))
						pendingUrl.add(s);
				}
			}
			
		}
		
	}
	
	public static ArrayList<String> getSubURLs(String urlString) {
		ArrayList<String> list = new ArrayList<>();
		
		try {
			java.net.URL url = new java.net.URL(urlString);
			Scanner input = new Scanner(url.openStream());
			int current = 0;
			while (input.hasNext()) {
				String line = input.nextLine();
				current = line.indexOf("http:", current);
				
				while (current > 0) {
					int endIndex = line.indexOf("\"", current);
					if (endIndex > 0) {
						list.add(line.substring(current, endIndex));
						current = line.indexOf("http:", endIndex);
					}
					else 
						current = -1;
					}
				}
			}catch (Exception e) {
				System.out.print("Error : " + e.getMessage());
		}
		return list;
	}
	
}

