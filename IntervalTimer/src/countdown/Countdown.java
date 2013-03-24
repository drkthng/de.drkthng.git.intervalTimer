package countdown;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Copyright (c) 2013 Dirk Thonig
 * All rights reserved.
 */

/**
 * @author "Dirk Thonig"
 *
 */
public class Countdown implements ActionListener{

    private boolean isOver;
    private final int seconds;
    private int secondCounter;
    private Timer timer;
    private JLabel timeLabel;
    private SimpleDateFormat format;
    
    public Countdown(int seconds, JLabel timeLabel) {
        this.isOver = false;
        this.seconds = seconds;
        this.format = new SimpleDateFormat("HH:mm:ss");
    }
    
    public void restart() {
        this.isOver = false;
        secondCounter = seconds;
        updateTimeLabel();
        timer = new Timer(1000, this);
    }
    
    public void start() {
        restart();
    }
    
    public boolean isOver() {
        return isOver;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        secondCounter--;
        if (secondCounter <= 0) {
            isOver = true;
            timer.stop();
        }
        updateTimeLabel();
    }
    
    private void updateTimeLabel() {
        int counterInMilliseconds = secondCounter * 1000;
        timeLabel.setText(format.format(new Date(counterInMilliseconds)));
    }

}
