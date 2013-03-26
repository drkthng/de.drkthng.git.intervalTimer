package countdown;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
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
        timer.setRepeats(true);
        timer.start();
    }
    
    public void start() {
        restart();
    }
    
    public boolean isOver() {
        return isOver;
    }
    
    /**
     * getCountdownLength()<br><br>
     * 
     * Return the number of seconds the countdown will last
     * 
     * @return int seconds
     */
    public int getCountdownLength() {
        return seconds;
    }
}
