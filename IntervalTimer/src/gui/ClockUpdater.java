package gui;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;

/**
 * @author "drkthng"
 *
 */
public class ClockUpdater implements DisplayUpdater{

    private JLabel labelSeconds, labelMinutes, labelHours;
   
    public ClockUpdater(JLabel labelSeconds, JLabel labelMinutes, JLabel labelHours) {
        this.labelSeconds = labelSeconds;
        this.labelMinutes = labelMinutes;
        this.labelHours = labelHours;
        resetLabels();
    }
    
    private void resetLabels() {
        update(0);
    }
    
    @Override
    public void update(int remainingSeconds) {
        int seconds = remainingSeconds % 60;
        int minutes = (remainingSeconds / 60) % 60;
        int hours = remainingSeconds / 3600;
        labelSeconds.setText(intTo2DigitString(seconds));
        labelMinutes.setText(intTo2DigitString(minutes));
        labelHours.setText(intTo2DigitString(hours));
    }
    
    private String intTo2DigitString(int number) {
        return String.format("%02d", number);
    }


}
