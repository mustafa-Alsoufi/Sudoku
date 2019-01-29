import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class undoListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	
		undo_Stack undo= new undo_Stack();
		game_page gp = new game_page();
		result_checker result = new result_checker();
		if (undo.elements() >= 1 &&  result.isWon() == false)
		{
			int x = undo.top()[1];
			int y = undo.top()[2];
			gp.values[x][y] = 0 ;
			gp.cell[x][y].get_tf().setText(null);
			gp.cell[x][y].get_tf().setBackground(Color.white);
			gp.cell[x][y].get_tf().setEditable(true);
			undo.pop();
			undo.display();
		}
		else if(result.isWon() == true)
		{
			gp.set_error("You already WON! Restart now");
			gp.err.setBounds(68, 275, 300, 50);

		}
		else if(undo.elements() == 0)
		{
			gp.set_error("Nothing to undo");
			gp.err.setBounds(138, 275, 300, 50);

		}
		else
		{
			gp.set_error("not sure what to say!");
		}
		
	}
	
}
