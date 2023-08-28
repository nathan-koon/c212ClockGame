package Problem5;

import javax.swing.*;

public class Display extends JPanel {
    private JLabel display;
    private ClockControl clockControl;
    public Display(ClockControl clockControl){
        this.display = clockControl.getDisplay();
        this.clockControl = clockControl;
        this.add(display);
    }
    public void updateDisplay(){
        this.display = this.clockControl.getDisplay();
        this.repaint();
    }

}
