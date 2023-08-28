package Problem5;

import javax.swing.*;
import java.awt.*;

public class Runner {
    public static JFrame frame;
    public Runner(){
    }
    public static void run() {
        frame = new JFrame();
        frame.setTitle("Clock Guesser Game");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        ClockControl clockControl = new ClockControl();
        ClockComponent clockComponent = new ClockComponent(clockControl);
        Display d = new Display(clockControl);
        frame.add(clockControl, BorderLayout.SOUTH);
        frame.add(d, BorderLayout.NORTH);
        frame.add(clockComponent, BorderLayout.CENTER);
        frame.setVisible(true);
        while(frame.isVisible()){
            d.updateDisplay();
        }
    }
}
