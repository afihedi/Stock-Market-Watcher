import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/** @author frankihediohanma **/
public class MarketDriver implements ActionListener {
	private JButton[] buttons; //the buttons of the different stocks
	private JFrame frame; //the frame of the driver
	private JPanel panel;
	
	
	//Constructor
	public MarketDriver() {
		frame = new JFrame();
		buttons = new JButton[50];
		
		//adds the buttons for each stock in the order given by the Tickers enum
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(Tickers.values()[i].getTicker());
			buttons[i].addActionListener(this);
		}
		
		JLabel intro = new JLabel("<html>" + "Click on the ticker to see the stock's score and report" + "<html>");
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0, 5));
		for(int i = 0; i < buttons.length; i++) {
			panel.add(buttons[i]);
		}
		panel.add(intro);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Stock Market Score Watcher");
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new MarketDriver();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame tickerWindow = new JFrame("Stock Market Watcher"); //creates new frame
		frame.setVisible(false);
		
		JButton back = new JButton("BACK"); //the back button
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				tickerWindow.setVisible(false);
			}
			
		});
		
		JLabel title = new JLabel();
		for(JButton button : buttons) {
			if(e.getSource() == button) {
				String text = button.getText();
				for(Tickers t : Tickers.values()) {
					if(t.getTicker().equals(text)) {
						title = new JLabel(t.toString() + " (" + t.getTicker() + ")");
					}
				}
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new FlowLayout());
		panel.add(back,BorderLayout.LINE_START);
		panel.add(title, BorderLayout.CENTER);
		
		tickerWindow.add(panel, BorderLayout.CENTER);
		tickerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tickerWindow.pack();
		tickerWindow.setVisible(true);
	}

}
