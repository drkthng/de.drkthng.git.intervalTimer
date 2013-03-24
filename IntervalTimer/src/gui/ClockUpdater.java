/**
 * Copyright (c) 2013 Dirk Thonig
 * All rights reserved.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;

/**
 * @author "Dirk Thonig"
 *
 */
public class ClockUpdater implements ActionListener{

    private SimpleDateFormat format;
    private JLabel timeLabel;
   
    public ClockUpdater(JLabel label) {
        this.format = new SimpleDateFormat("HH:mm:ss");
        this.timeLabel = label;
    }
    
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
