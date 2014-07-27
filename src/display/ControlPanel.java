package display;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import common.Constants;


/**
 * A Panel for the controlls (chose what item to pick up, etc)
 * @author Arni
 *
 */
public class ControlPanel extends JPanel{
    public ControlPanel() {
        this.setPreferredSize(new Dimension(Constants.CONTROLL_WIDTH,Constants.BOARD_HEIGHT));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JButton("Test"));
        this.add(new JButton("Test"));
        this.add(new JButton("Test"));
    }
}