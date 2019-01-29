import java.awt.Color;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;

public class timer extends Component{
	private int curr_time = 3;
	private static boolean freeze = false;
	Color color = Color.decode("#59FFA0");

  //  JLabel the_time = time1;
	public timer()
	{
		
	}
public timer(int time)
{
curr_time = time;	
}
public timer(textField[][] grid, JLabel countdownLabel) {
	//textField abort = new textField(); 
 //   final JLabel countdownLabel = new JLabel("05:00");
  //  timer time1 = new timer();
	
	final Timer t = new Timer(1000, new ActionListener() {
		//curr_time = 301;
        @Override
        public void actionPerformed(ActionEvent e) {
        	if (freeze == false)
        	{
        		curr_time--;
        }
            countdownLabel.setText("Timer: "+format(curr_time / 60) + ":" + format(curr_time % 60));
            if (curr_time == 0) {
                final Timer timer = (Timer) e.getSource();

                timer.stop();
               for (int i=0;i<4;i++)
                {
                	for (int j=0;j<4;j++)
                	{
                		grid[i][j].get_tf().setEditable(false);
                		game_page gp = new game_page("Game is over!");
            			gp.err.setBounds(140, 275, 300, 50);

                			
                    }
                }
            }

            
            else if (curr_time <= 60 )
            {
            	countdownLabel.setForeground(Color.red);
            }
            else if(curr_time > 60)
            {
            	countdownLabel.setForeground(color);
            }
        	}
         
    });
      t.start();
   }

  private String format(int i) {
      String result = String.valueOf(i);
      if (result.length() == 1) {
          result = "0" + result;
      }
      return result;
  }

 public int get_time() {
	 return this.curr_time;
 }

public void freeze_time(boolean b)
{
	freeze = b;
}
/* public void reset_timer()
 {
	 curr_time = 301;
 }*/
}


