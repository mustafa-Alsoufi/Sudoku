import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class textField extends JTextField{
	private JTextField tf;
//	public static boolean flag;
	game_page gp=new game_page();
	Font font = new Font("Microsoft Sans Serif",Font.ROMAN_BASELINE,24);
	Color color = Color.decode("#e4db55");
	
/*public textField(int n)
{
	flag = false;
	}*/
public textField()
{
	
	tf = new JTextField() {
		  @Override protected void paintComponent(Graphics g) {
		    if (!isOpaque() && getBorder() instanceof RoundedBorder) {
		      Graphics2D g2 = (Graphics2D) g.create();
		      g2.setPaint(getBackground());
		      g2.fill(((RoundedBorder) getBorder()).getBorderShape(
		          0, 0, getWidth() - 1, getHeight() - 1));
		      g2.dispose();
		    }
		    super.paintComponent(g);
		  }
		  @Override public void updateUI() {
			    super.updateUI();
			    setOpaque(false);
			    setBorder(new RoundedBorder());
			  }
		};
}
public JTextField get_tf()
{
	tf.addKeyListener(new KeyAdapter() {
	   public void keyTyped(KeyEvent e) {
	      int c = e.getKeyChar();
	      if ( ((c < '1') || (c > '4')) || (tf.getText().length() >= 1) )
	      {
	         e.consume(); 
	         // ignore event
	      }
	   }
	});
	tf.setHorizontalAlignment(JTextField.CENTER);
	tf.setFont(font);
	return tf;	
}


public void checkRow(JTextField jf, int row, int col)
{
	undo_Stack undo = new undo_Stack();
	timer t= new timer(301); //doesn't matter what u put here
	tf.addKeyListener(new KeyAdapter() {
	   public void keyTyped(KeyEvent e) {
	      char c = e.getKeyChar();
	     // if (gp.checkRow(Integer.toString(2), row)) {
	    	  if (((c < '1') || (c > '4')) || (tf.getText().length() >= 1) || t.get_time() <= 0) {
	 	         e.consume(); 
	 	         // ignore event
	 	      }
	    	  else 
	    	  {
	    		  System.out.println(c);
	    		  System.out.println("--------------------");
	    			for(int row=0; row<4;row++)
	    			{
	    				for(int column=0; column<4;column++)
	    				{
	    						System.out.print(game_page.values[row][column]+" ");		//		cell[0][0].setText();
	    				}
	    				System.out.println();
	    			}
	    		  
	    			  if ( gp.check_row(Character.getNumericValue(c), row) != 0 || gp.check_column(Character.getNumericValue(c), col) != 0 || gp.checkSubGrid(Character.getNumericValue(c), row, col) == false && t.get_time() > 0)
	    			  {
	    				  if (t.get_time() == 0)
	    				  {
	    					  gp.set_error("Game is already over!");
	    				  }
	    				  else
	    				  {
	    					  jf.setBackground(Color.RED);
		    				  if (( gp.check_row(Character.getNumericValue(c), row) != 0)) 
		    					{
		    					  gp.set_error("Same number in ROW!");
		    						gp.err.setBounds(100, 275, 300, 50);
		    					}
		    				  else if(gp.check_column(Character.getNumericValue(c), col) != 0 )
		    				  	{
		    					  gp.set_error("Same number in COLUMN!");
		    						gp.err.setBounds(80, 275, 300, 50);

		    				  	}
		    				  else if(gp.checkSubGrid(Character.getNumericValue(c), row, col) == false)
		    				  	{
		    					  gp.set_error("Same number in GRID!");
		    				  	}
	    				  }
	    				  
	    			  }
	    			  else if ( gp.check_row(Character.getNumericValue(c), row) == 0 && gp.check_column(Character.getNumericValue(c), col) == 0 && gp.checkSubGrid(Character.getNumericValue(c), row, col))
	    			  {
	    				  if (t.get_time() == 0)
	    				  {
	    					  gp.set_error("Game is already over!");
	    				  }
	    				  else
	    				  {
	    					  gp.set_error("");
	    					  jf.setBackground(Color.GREEN);
	    					  jf.setForeground(Color.BLACK);
	    					  game_page.values[row][col] = Character.getNumericValue(c);
	    					  // setting the value of the textfield to whatever number key is pressed
	    					  gp.cell[row][col].get_tf().setText(String.valueOf(c));
	    					  // making that textField to be null.
	    					  gp.cell[row][col].get_tf().setEditable(false);
	    					  //set_flag(true);
	    					  undo.push(Character.getNumericValue(c), row, col);
	    					  undo.display();
	    				  }
	    			  }
	    			  else
	    				  jf.setBackground(Color.MAGENTA);
	    	  		  }
	     	   }
	   
	});

	
	tf.setHorizontalAlignment(JTextField.CENTER);
	tf.setFont(font);	
}

}
