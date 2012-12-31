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
	private JComboBox cbox;
	private String[] models = {"BMX", "Huffy", "Murray", "Trek", "Schwinn"};

	BikeOrder() {

		cbox = new JComboBox(models);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		panel.add(cbox);

		JFrame frame = new JFrame("My Bike Order");
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(300,80);

	}

	public static void main(String[] args){
		BikeOrder bikeOrder = new BikeOrder();
	}
}
