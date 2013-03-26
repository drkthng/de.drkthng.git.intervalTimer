package countdown;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private HashSet<CountdownListener> setOfListeners;
    
    public Countdown(int seconds, CountdownListener listener) {
        this.isOver = false;
        this.seconds = seconds;
        this.setOfListeners = new HashSet<CountdownListener>();
        setOfListeners.add(listener);
    }
    
    public void addListener(CountdownListener listener) {
        setOfListeners.add(listener);
    }
    
    public void removeListener(CountdownListener listener) {
        setOfListeners.remove(listener);
    }
    
    private void updateListeners(int remainingSeconds) {
        for (CountdownListener listener : setOfListeners) {
            listener.onCountdownEvent(remainingSeconds);
        }
    }
    
    public void restart() {
        this.isOver = false;
        secondCounter = seconds;
        timer = new Timer(1000, (new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent event) {
                secondCounter--;
                if (secondCounter <= 0) {
                    isOver = true;
                    ((Timer)event.getSource()).stop();
                } 
                updateListeners(secondCounter);
            }
        }));
        timer.setRepeats(false);
        timer.start();
    }
    
    public void start() {
        restart();
    }
    
    public boolean isOver() {
        return isOver;
    }
}
