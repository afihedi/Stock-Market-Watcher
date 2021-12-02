/** Represents the tickers for 50 most popular stocks **/
/** @author frankihediohanma **/
public enum Tickers {
	Tesla("TSLA"), Apple("AAPL"), Amazon("AMZN"), Microsoft("MSFT"), Boeing("BA"), 
	Facebook("FB"), AMD("AMD"), BankOfAmerica("BAC"), Alibaba("BABA"), JPMorgan("JPM"),
	Nvidia("NVDA"), AlphabetA("GOOGL"), Nio("NIO"), ViacomCBS("VIAC"), Square("SQ"), 
	AlphabetC("GOOG"), Upstart("UPST"), Micron("MU"), GameStop("GME"), MasterCard("MA"), 
	Baidu("BIDU"), PayPal("PYPL"), WellsFargo("WFC"), DollarGeneral("DG"), Netflix("NFLX"),
	ExxonMobile("XOM"), GeneralMotors("GM"), Intel("INTC"), Riot("RIOT"), AMC("AMC"), 
	Pinduoduo("PDD"), Citigroup("C"), ZoomVideo("ZM"), WaltDisney("DIS"), NXP("NXPI"), 
	Hartford("HIG"), Crowdstrike("CRWD"), PlugPower("PLUG"), TakungArt("TKAT"), Palantir("PLTR"),
	LamResearch("LRCX"), Visa("V"), Broadcom("AVGO"), AmericanAirlines("AAL"), Jaiyan("JFIN"), 
	Carnival("CCL"), Adobe("ADBE"), BerkshireHathaway("BRK-B"), HomeDepot("HD"), Nike("NKE");
	//Chose the 50 most popular stocks to start out, keeping it simple to start and then getting harder
	
	private final String ticker; //The ticker of each stock
	
	//Constructor
	private Tickers(String string) {
		ticker = string;
	}
	
	/** @return the ticker of the stock**/
	public String getTicker() {
		return ticker;
	}
	
}
