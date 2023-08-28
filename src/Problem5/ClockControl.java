package Problem5;
import javax.swing.*;
import java.awt.*;
import java.time.Clock;

public class ClockControl extends JPanel {
    private ClockGame clockGame;
    private JButton timeSetButton;
    private JTextField hourTextField;
    private JTextField minuteTextField;
    private int hour;
    private int minute;
    private int minuteGuess;
    private int hourGuess;
    private ClockComponent clockComponent;
    public ClockControl(){
        clockGame = new ClockGame(this);
        clockComponent = new ClockComponent(this);
        hourTextField = new JTextField(10);
        add(new JLabel("Hour: "));
        add(hourTextField);
        minuteTextField = new JTextField(10);
        add(new JLabel("Minute: "));
        add(minuteTextField);
        timeSetButton = new JButton("Guess");
        add(timeSetButton,BorderLayout.AFTER_LINE_ENDS);
        timeSetButton.addActionListener(e -> {
            this.minuteGuess = Integer.parseInt(minuteTextField.getText());
            this.hourGuess = Integer.parseInt(hourTextField.getText());
            clockGame.checkGuess(this.hourGuess,this.minuteGuess);
            this.minute = clockGame.generateMinute();
            this.hour = clockGame.generateHour();
            this.clockComponent.repaint();
        });
        this.minute = clockGame.generateMinute();
        this.hour = clockGame.generateHour();
        this.clockComponent.repaint();
    }

    public int getHour(){
        return this.hour;
    }
    public int getMinute(){
        return this.minute;
    }
    public boolean getGuess(){
        return clockGame.getGuess();
    }
    public JLabel getDisplay(){
        return this.clockGame.getDisplay();
    }
}
