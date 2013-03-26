package startup;

import gui.MainFrameController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 * @author "drkthng"
 *
 */
public class IntervalTimerApp extends JFrame{

    
    
    /**
     * main method: start the gui-application IntervalTimer
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrameController();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
