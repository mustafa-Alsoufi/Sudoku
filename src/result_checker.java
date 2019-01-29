import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class result_checker implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	private static boolean status;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		game_page gp = new game_page();
		if (gp.cells_with_values() == 16) // meaning all cells are full
		{
				gp.set_error("\t\tHurrah! You WON!");

				status = true;
				for (int i=0;i<4;i++)
                {
                	for (int j=0;j<4;j++)
                	{
                		gp.cell[i][j].get_tf().setEditable(false);
                		 timer t = new timer();
                		 t.freeze_time(true);
                    }
                }
			
		}
		else	
			gp.set_error("Game not Yet finished!");
			gp.err.setBounds(104, 275, 300, 50);

		
	}
	public boolean isWon()
	{
		return status;
	}
	public void set_status(boolean b)
	{
		status = b;
	}
}
