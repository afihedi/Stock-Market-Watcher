import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
/** @author frankihediohanma **/
/** A special wrapper class for the URL**/
public class SiteRetriever {
	private URL marketNews;
	private Tickers ticker;
	
	/** A constuctor 
	  @param takes the stock and creates a URL to that stock's benzinga page **/
	public SiteRetriever(Tickers t) {
		try {
			marketNews = new URL("https://benzinga.com/stock/" + t.getTicker().toLowerCase() + "/");
			ticker = t;
		} catch (IOException e){
			System.out.println("Internet Issue");
		} catch (NullPointerException n) {
			System.out.println("Invalid Site");
		}
	}
	
	/** @return the URL for the benziga page **/
	public URL getURL() {
		return marketNews;
	}
	
	/** @return the ticker for the site of the stock **/
	public Tickers getTicker() {
		return ticker;
	}
	
	//Simple toString method
	@Override
	public String toString() {
		return marketNews.toString();
	}
	
	/** Creates a string containing all the words of site
	  @return the string version of the contents of the site **/
	public String siteReader() {
		// Get the input stream through URL Connection
        String result = "";
        
		try {
			Scanner scanner = new Scanner(marketNews.openStream());
			StringBuffer page = new StringBuffer();
			while(scanner.hasNext()) {
				String line = scanner.nextLine() + "\n";
				page.append(line);
			}
			scanner.close();
			result = page.toString();
		} catch (IOException e) {
			return "Internet Issues";
		}
        return result;
	}
	
}
