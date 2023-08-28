package Problem5;

import javax.swing.*;
import java.awt.*;
import java.time.Clock;

public class ClockGame extends JPanel{
    private boolean correctGuess;
    private ClockControl clockControl;
    private int level;
    private int score;
    private String levelDisplay;
    private String scoreDisplay;
    private JLabel display = new JLabel();

    public ClockGame(ClockControl clockControl) {
        this.level = 1;
        this.score = 0;
        this.levelDisplay = "Level: " + this.level;
        this.scoreDisplay = "Score: " + this.score;
        this.clockControl = clockControl;
        this.updateDisplay();
        this.add(display);
    }

    public int generateMinute(){
        int output;
        if(this.level == 1){
            output = 0;
        } else if(this.level == 2){
            output = ((int)(1+Math.random()*60)/15 * 15)%60;
        } else if (this.level == 3){
            output = ((int)(1+Math.random()*60)/5 * 5)%60;
        } else{
            output = (int)(1+Math.random()*60)%60;
        }
        return output;
    }

    public int generateHour(){
        return (int)(1+Math.random()*12);
    }

    public void updateLevel(){
        if(this.score < 5){
            this.level = 1;
        }else if(this.score < 10){
            this.level = 2;
        }else if(this.score < 15){
            this.level = 3;
        }else{
            this.level = 4;
        }
    }

    public void checkGuess(int hour, int minute){
        if(hour == this.clockControl.getHour() && minute == this.clockControl.getMinute()){
            score++;
            this.updateLevel();
            this.correctGuess = true;
            this.updateDisplay();
        } else{
            this.correctGuess = false;
            this.updateDisplay();
        }
    }

    public void updateDisplay(){
        this.levelDisplay = "Level: " + this.level;
        this.scoreDisplay = "Score: " + this.score;
        display.setText(this.levelDisplay + "         " + this.scoreDisplay);
        this.repaint();
    }

    public int getScore(){
        return this.score;
    }
    public int getLevel(){
        return this.level;
    }

    public boolean getGuess(){
        return this.correctGuess;
    }

    public JLabel getDisplay(){
        return this.display;
    }

}
