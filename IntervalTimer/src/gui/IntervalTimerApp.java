package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

/**
 * @author "drkthng"
 *
 */
public class IntervalTimerApp extends JFrame{

    private JPanel contentPane;
    private JLabel labelSeconds, labelMinutes, labelHours;
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
                    frame.setResizable(false);
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
            visualTimerPanel.setBorder(new EmptyBorder(5,5,5,5));
            visualTimerPanel.setLayout(new FlowLayout());
            Font fontTimeLabels = new Font("Dialog", Font.PLAIN, 72);
            JLabel[] colons = {new JLabel(":"), new JLabel(":")};
            colons[0].setFont(fontTimeLabels);
            colons[1].setFont(fontTimeLabels);
            labelSeconds = new JLabel();
            labelSeconds.setFont(fontTimeLabels);
            labelMinutes = new JLabel();
            labelMinutes.setFont(fontTimeLabels);
            labelHours = new JLabel();
            labelHours.setFont(fontTimeLabels);
            visualTimerPanel.add(labelHours);
            visualTimerPanel.add(colons[0]);
            visualTimerPanel.add(labelMinutes);
            visualTimerPanel.add(colons[1]);
            visualTimerPanel.add(labelSeconds);
            contentPane.add(visualTimerPanel);
        }
        // create mid panel: START STOP BUTTONS
        {
            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setBorder(new EmptyBorder(5,5,5,5));
            final int gapBetweenElements = 20;
            buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, gapBetweenElements, 0));
            buttonStart = new JButton("Start");
            buttonStop = new JButton("Stop");
            int buttonWidth = 150;
            int buttonHeight = 50;
            Dimension buttonDimension = new Dimension(buttonWidth, buttonHeight);
            buttonStart.setPreferredSize(buttonDimension);
            buttonStop.setPreferredSize(buttonDimension);
            Font fontButtons = new Font("Dialog", Font.PLAIN, 36);
            buttonStart.setFont(fontButtons);
            buttonStop.setFont(fontButtons);
            buttonsPanel.add(buttonStart);
            buttonsPanel.add(buttonStop);
            contentPane.add(buttonsPanel);
        }
        // create bottom panel: list of timers, add new timer, other options
        {
            JPanel optionsPanel = new JPanel();
            optionsPanel.setBorder(new EmptyBorder(5,5,5,5));
            
            contentPane.add(optionsPanel);
        }
        
        ClockUpdater clockUpdater = new ClockUpdater(labelSeconds, labelMinutes, labelHours);
        clockUpdater.startCountdown(30);
        
    }

}
