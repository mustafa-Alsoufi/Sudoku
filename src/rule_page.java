import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class rule_page extends Component{
public rule_page()
{
	Font font = new Font("Microsoft Sans Serif",Font.ROMAN_BASELINE,18);
	int val[][] = new int[4][4];
	String tab = "<html>&#09;&#09;&nbsp;&nbsp;<html/>";
	JPanel rulesPanel = new JPanel(null);
	JFrame rulesFrame = new JFrame("Sudoku");
	
	rulesFrame = new JFrame("Sudoku");
	rulesFrame.setVisible(true);
	rulesFrame.setSize(400, 500);
	rulesFrame.setResizable(false);
	rulesFrame.setLocationRelativeTo(null);
	Color color = Color.decode("#34495e");
	rulesPanel = new JPanel(null);
	rulesPanel.setBackground(color);
	rulesFrame.add(rulesPanel);
	JLabel rules = new JLabel();
	rules.setBounds(10, 0, 390, 200);
	
	rules.setText(tab+"<html><font color = #00b78f>Rules!</font><br/><br/>"
			+ "1: The numbers should be between 1 and 4"
			+ " <br/>2: Numbers shouldn't be duplicated in raw"
			+ " <br/>3: Numbers shouldn't be duplicated in column"
			+ " <br/>4: In the subgrid No duplicate Numbers"
			+ " <br/>5: You can UNDO only if the cell turns<font color =green> GREEN</font></html>");
	rulesPanel.add(rules);
	rules.setFont(font);
	rules.setForeground(Color.white);
	
	JButton start = new JButton("Start Game");
	rulesPanel.add(start);
	start.setBounds(130, 300, 130, 50);
	start.setFont(font);
	// adding mouse motion listener to start button
	mouse m = new mouse(start);

	/*	start.addMouseListener(new MouseAdapter() {
		
		Color buttonColr = Color.decode("#C71585");
		
		     public void mouseEntered(MouseEvent me) {
		    	 start.setFocusPainted(true);
		    	 start.setBorderPainted(true);
		    	 start.setContentAreaFilled(false);
		    	 start.setForeground(buttonColr);

		     }
		     public void mouseExited(MouseEvent me) {
		    	 start.setFocusPainted(true);
		    	 start.setBorderPainted(true);
		    	 start.setContentAreaFilled(true);
		    	 start.setForeground(Color.black);
		      }
		});*/
	
	click click = new click(rulesFrame);//,val);
	start.addActionListener(click);
}
}
