package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import countdown.Countdown;
import countdown.CountdownListener;

/**
 * @author "drkthng"
 *
 */
public class MainFrameController implements CountdownListener{
    
    private MainFrame mainFrame;
    private List<Countdown> listOfCountdowns;
    private DisplayUpdater display;
    
    public MainFrameController() {
        mainFrame = new MainFrame();
        display = mainFrame.getClockUpdaterInstance();
        setListeners();
        //test
        mainFrame.getCountdownListModel().addElement(new Countdown(30, this));
    }
    
    private void setListeners() {
        mainFrame.buttonStartAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                DefaultListModel listModel = mainFrame.getCountdownListModel();
                ArrayList<Countdown> listOfCountdowns = new ArrayList<Countdown>();
                for (int i = 0; i < listModel.getSize(); i++) {
                    ((Countdown)listModel.get(i)).start();
                }
                
            }
        });
    }
    
    public void startCountdown(int seconds) {
        Countdown countdown = new Countdown(seconds, this);
        countdown.start();
    }

    /* (non-Javadoc)
     * @see countdown.CountdownListener#onCountdownEvent(int)
     */
    @Override
    public void onCountdownEvent(int remainingSeconds) {
        display.update(remainingSeconds);
        if (remainingSeconds == 0) {
            // ring the alarm
            // make display blink red
        }
    }
    
}
