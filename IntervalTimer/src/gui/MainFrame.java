package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

/**
 * @author "drkthng"
 *
 */
public class MainFrame extends JFrame{

    private final int WIDTH = 400;
    private final int HEIGHT = 400;
    
    private JPanel contentPane;
    private JLabel labelSeconds, labelMinutes, labelHours;
    private JButton buttonStart, buttonStop;
    private JList listOfCountdowns;
    private DefaultListModel listModel;
    private ClockUpdater clockUpdater;
    
    /**
     * constructor: create the gui and set defaults
     */
    public MainFrame() {
        setTitle("Interval Timer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, WIDTH, HEIGHT);
        init();
        setResizable(false);
        setVisible(true);
    }
    
    public void buttonStartAction(ActionListener action) {
        buttonStart.addActionListener(action);
    }
    
    public void buttonStopAction(ActionListener action) {
        buttonStop.addActionListener(action);
    }
    
    public ClockUpdater getClockUpdaterInstance() {
        if (clockUpdater == null) {
            clockUpdater = new ClockUpdater(labelSeconds, labelMinutes, labelHours);
        }
        return clockUpdater;
    }
    
    public DefaultListModel getCountdownListModel() {
        return listModel;
    }
    
    private void init() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        final int borderLayoutGap = 10;
        contentPane.setLayout(new BorderLayout(0, borderLayoutGap));
        setContentPane(contentPane);
        // create top panel: visualization of the timer
        {
            JPanel visualTimerPanel = new JPanel();
            visualTimerPanel.setBorder(null);
            visualTimerPanel.setLayout(new FlowLayout());
            Font fontTimeLabels = new Font("Dialog", Font.PLAIN, 80);
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
            contentPane.add(visualTimerPanel, BorderLayout.NORTH);
        }
        // create mid panel: START STOP BUTTONS
        {
            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setBorder(null);
            final int gapBetweenElements = 20;
            buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, gapBetweenElements, 0));
            buttonStart = new JButton("Start");
            buttonStop = new JButton("Stop");
            int buttonWidth = 160;
            int buttonHeight = 50;
            Dimension buttonDimension = new Dimension(buttonWidth, buttonHeight);
            buttonStart.setPreferredSize(buttonDimension);
            buttonStop.setPreferredSize(buttonDimension);
            Font fontButtons = new Font("Dialog", Font.PLAIN, 36);
            buttonStart.setFont(fontButtons);
            buttonStop.setFont(fontButtons);
            buttonsPanel.add(buttonStart);
            buttonsPanel.add(buttonStop);
            contentPane.add(buttonsPanel, BorderLayout.CENTER);
        }
        // create bottom panel: list of timers, add new timer, other options
        {
            JPanel optionsPanel = new JPanel();
            optionsPanel.setBorder(null);
            listModel = new DefaultListModel();
            listOfCountdowns = new JList(listModel);
            listOfCountdowns.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            final int listHeight = 160;
            final int listWidth = 340;
            Dimension scrollPaneDimension = new Dimension(listWidth, listHeight);
            JScrollPane listScroller = new JScrollPane(listOfCountdowns,
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            listScroller.setPreferredSize(scrollPaneDimension);
            
            optionsPanel.add(listScroller);
            contentPane.add(optionsPanel, BorderLayout.SOUTH);
        }
        
        pack();
    }

}
