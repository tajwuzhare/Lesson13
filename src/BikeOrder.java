import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: heisenberg
 * Date: 12/30/12
 * Time: 8:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class BikeOrder {
	private JComboBox comboBox;
	private JTextField textField;
	private JButton jButton;
	private String[] models = {"Please Select a Model", "BMX", "Huffy", "Murray", "Trek", "Schwinn"};
	private JFrame frame;

	BikeOrder() {

		comboBox = new JComboBox(models);
		textField = new JTextField();
		jButton = new JButton("Validate");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		panel.add(comboBox);
		panel.add(textField);
		panel.add(jButton);

		frame = new JFrame("My Bike Order");
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(300,160);
		frame.setLocationRelativeTo(null);

		BikeOrderEngine bikeEngine = new BikeOrderEngine(this);

		comboBox.addActionListener(bikeEngine);
		textField.addActionListener(bikeEngine);
		jButton.addActionListener(bikeEngine);

	}

	public void setTextField() {

	}

	public String getTextField() {
		return textField.getText();
	}

	public String getBoxItem() {
		return (String)comboBox.getSelectedItem();
	}

	public void validateOrder(String bike, double amt) throws TooManyBikesException {
		if (bike == "Trek" && amt > 100) {
			throw new TooManyBikesException("Damn, that's too many!");
		}
		else if (bike == "Schwinn" && amt > 50) {
			throw new TooManyBikesException("Why so many Schwinns dawg?");
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public static void main(String[] args){
		BikeOrder bikeOrder = new BikeOrder();
	}
}
