import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class textListener implements ActionListener{
	
	private textField text;
	public textListener(textField text)
	{
		this.text = text;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		text.get_tf().setBackground(Color.green);
		text.get_tf().setForeground(Color.GRAY);
	}

}
