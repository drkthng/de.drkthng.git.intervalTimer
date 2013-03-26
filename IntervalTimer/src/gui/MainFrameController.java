package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import countdown.Countdown;
import countdown.CountdownListener;

/**
 * @author "drkthng"
 *
 */
public class MainFrameController implements CountdownListener{
    
    private MainFrame mainFrame;
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
                DefaultListModel<Countdown> listModel = mainFrame.getCountdownListModel();
                for (int i = 0; i < listModel.getSize(); i++) {
                    Countdown countdown = (Countdown)listModel.get(i);
                    display.update(countdown.getCountdownLength());
                    countdown.start();
                }
                
            }
        });
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
