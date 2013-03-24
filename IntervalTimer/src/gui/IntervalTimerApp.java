/**
 * Copyright (c) 2013 Dirk Thonig
 * All rights reserved.
 */
package gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

/**
 * @author "Dirk Thonig"
 *
 */
public class IntervalTimerApp extends JFrame{

    private JPanel contentPane;
    private JLabel timeLabel;
    private JButton buttonStart, buttonStop;
    
    /**
     * main method: start the gui-application IntervalTimer
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IntervalTimerApp frame = new IntervalTimerApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    
    /**
     * constructor: create the gui and set defaults
     */
    public IntervalTimerApp() {
        setTitle("Interval Timer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        setContentPane(contentPane);
        // create top panel: visualization of the timer
        {
            JPanel visualTimerPanel = new JPanel();
            visualTimerPanel.setBorder(null);
            timeLabel = new JLabel();
            timeLabel.setFont(new Font("Dialog", Font.PLAIN, 64));
            visualTimerPanel.add(timeLabel);
            contentPane.add(visualTimerPanel);
        }
        // create mid panel: start stop buttons
        {
            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setBorder(null);
            buttonsPanel.setLayout(new FlowLayout());
            buttonStart = new JButton("Start");
            buttonStop = new JButton("Stop");
            buttonsPanel.add(buttonStart);
            buttonsPanel.add(buttonStop);
            contentPane.add(buttonsPanel);
        }
        // create bottom panel: list of timers, add new timer, other options
        {
            JPanel optionsPanel = new JPanel();
            optionsPanel.setBorder(null);
        }
        
        
    }

}
