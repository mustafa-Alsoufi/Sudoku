import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;

public class mouse implements ActionListener{	
	public mouse(JButton button)
	{
		
	
		button.addMouseListener(new MouseAdapter() {
	
	Color buttonColr = Color.decode("#52FFB8");
	
	     public void mouseEntered(MouseEvent me) {
	    	 button.setFocusPainted(true);
	    	 button.setBorderPainted(true);
	    	 button.setContentAreaFilled(false);
	    	 button.setForeground(buttonColr);

	     }
	     public void mouseExited(MouseEvent me) {
	    	 button.setFocusPainted(true);
	    	 button.setBorderPainted(true);
	    	 button.setContentAreaFilled(true);
	    	 button.setForeground(Color.black);
	      }
	});
	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

}
