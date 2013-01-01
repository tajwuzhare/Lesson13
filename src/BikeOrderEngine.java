import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: heisenberg
 * Date: 12/30/12
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class BikeOrderEngine implements ActionListener {
	BikeOrder parent;
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		//To change body of implemented methods use File | Settings | File Templates.
		JComboBox cb;
		JTextField tf;
		JButton jb;
		Object eventSource = actionEvent.getSource();

		if (eventSource instanceof JComboBox) {
			cb = (JComboBox) eventSource;
			if (cb.getSelectedIndex() == 0) {
				return; //ensures "Please select model" will not be selected
			}
			String selectedBike = (String)cb.getSelectedItem();
			System.out.println("I like " + selectedBike + " bikes!");
		}
		else if (eventSource instanceof JTextField) {
			//todo: add text field logic
		}
		else if (eventSource instanceof JButton) {
			//todo: add button logic
			System.out.println(parent.getTextField());
			double num = Double.parseDouble(parent.getTextField());
			String bike = parent.getBoxItem();
			try {
				parent.validateOrder(bike, num);
			} catch (TooManyBikesException e) {
				e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
				JOptionPane.showMessageDialog(parent.getFrame(), e.getMessage(), "Error Message", JOptionPane.INFORMATION_MESSAGE);
			}

		}
	}

	BikeOrderEngine(BikeOrder order){
		parent = order;
	}
}
