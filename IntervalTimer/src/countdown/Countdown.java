package countdown;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * @author "drkthng"
 *
 */
public class Countdown{

    private boolean isOver;
    private final int seconds;
    private int secondCounter;
    private Timer timer;
    private ActionListener listener;
    
    public Countdown(int seconds, ActionListener listener) {
        this.isOver = false;
        this.seconds = seconds;
        this.listener = listener;
    }
    
    public void restart() {
        this.isOver = false;
        secondCounter = seconds;
        timer = new Timer(1000, this.listener);
        timer.setRepeats(true);
        timer.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent event) {
                secondCounter--;
                if (secondCounter <= 0) {
                    isOver = true;
                    ((Timer)event.getSource()).stop();
                }
                
            }
        });
        timer.start();
    }
    
    public void start() {
        restart();
    }
    
    public boolean isOver() {
        return isOver;
    }
}
