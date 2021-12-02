import java.net.URL;
import java.util.ArrayList;
/** @author frankihediohanma **/
/** Creates a point system and generates a score for each stock based on the news, and the stocks
  performace during that day, week, month, and year **/
public class PointCreator {
	
	private int score = 500; //the score each stock is given based on news and how the stock is doing overall
	
	
	//Constructor
	/**The constructor. 
	 * @param the ticker that the point creator will create a score for */
	public PointCreator(Tickers t) {
		
	}
	
	/** Gets the generated score*
	 @return the generated score * */
	public int getScore() {
		return score;
	}
	
	public String getStockPrice(SiteRetriever sr) {
		String value = "";
		String s = sr.siteReader();
		int stock = s.indexOf(sr.getTicker().toString());
		int start = s.indexOf("price current-data", stock);
		int end = s.indexOf("</span>", start);
		value = "$" + s.substring(start+20, end);
		return value;
	}
	
	public static void main(String[] args) {
		for(Tickers t : Tickers.values()) {
			PointCreator p = new PointCreator(t);
			SiteRetriever sr = new SiteRetriever(t);
			String x = p.getStockPrice(sr);
			System.out.println(x);
		}
		
	}
	
}
