import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


	public class click implements ActionListener
	{
		private JFrame frame;
		//static boolean flag = false;
		//private int[][] arr;
		
		public click(JFrame rulesframe)//, int[][] arr)
		{
			this.frame = rulesframe;
		//	this.arr = arr;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			game_page gp = new game_page(400,500);
			undo_Stack undo = new undo_Stack();
			result_checker result = new result_checker();
			result.set_status(false);
			// setting time to 301 Seconds
			timer t = new timer();
			t.freeze_time(false);
			undo.reset();
		}
		
		

}
