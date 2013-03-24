/**
 * Copyright (c) 2013 Dirk Thonig
 * All rights reserved.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

import countdown.Countdown;

/**
 * @author "Dirk Thonig"
 *
 */
public class ClockUpdater implements ActionListener{

    private JLabel labelSeconds, labelMinutes, labelHours;
    private int remainingSeconds;
   
    public ClockUpdater(JLabel labelSeconds, JLabel labelMinutes, JLabel labelHours) {
        this.labelSeconds = labelSeconds;
        this.labelMinutes = labelMinutes;
        this.labelHours = labelHours;
        resetLabels();
    }
    
    private void resetLabels() {
        updateLabels(0);
    }
    
    private void updateLabels(int remainingSeconds) {
        int seconds = remainingSeconds % 60;
        int minutes = (remainingSeconds / 60) % 60;
        int hours = remainingSeconds / 3600;
        labelSeconds.setText(intTo2DigitString(seconds));
        labelMinutes.setText(intTo2DigitString(minutes));
        labelHours.setText(intTo2DigitString(hours));
    }
    
    public void startCountdown(int seconds) {
        Countdown countdown = new Countdown(seconds, this);
        remainingSeconds = seconds;
        updateLabels(remainingSeconds);
        countdown.start();
    }
    
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        remainingSeconds--;
        updateLabels(remainingSeconds);        
    }
    
    private String intTo2DigitString(int number) {
        return String.format("%02d", number);
    }

}
