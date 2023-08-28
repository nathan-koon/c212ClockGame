package Problem5;
import javax.swing.*;
import java.awt.*;

public class ClockComponent extends JPanel {
    private ClockControl clockControl;
    private int centerX;
    private int centerY;
    private int radius;
    public ClockComponent(ClockControl clockControl){
        this.clockControl = clockControl;
        this.centerX = getWidth()/2;
        this.centerY = getHeight()/2;
        this.radius = 100;


    }

    public void drawClockCircle(Graphics2D g2d){
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.blue);
        g2d.fillOval(this.centerX - radius, this.centerY - radius, radius*2, radius*2);
    }
    public void drawHand(Graphics2D g2d, float angle, int offset, Color color, double radius){
        g2d.setColor(color);
        int ex = this.centerX + (int)(radius*(Math.cos(Math.toRadians(angle + offset))));
        int ey = this.centerY + (int)(radius*(Math.sin(Math.toRadians(angle + offset))));
        g2d.drawLine(this.centerX,this.centerY, ex, ey);
    }
    public void drawMinuteHand(Graphics2D g2d){
        int minute = clockControl.getMinute();
        float angle = minute*6;
        this.drawHand(g2d, angle, -90, Color.red,this.radius*0.9);
    }
    public void drawHourHand(Graphics2D g2d){
        int minute = clockControl.getMinute();
        int hour = clockControl.getHour();
        float angle = (float)(hour*30.0 + minute*0.5);
        this.drawHand(g2d, angle, -90, Color.white,this.radius*0.6);
    }
    public void drawNotches(Graphics2D g2d, float angle, int offset){
        if(angle%30 == 0){
            g2d.setColor(Color.RED);
            int sx = this.centerX + (int)(0.8*this.radius*(Math.cos(Math.toRadians(angle + offset))));
            int sy = this.centerY + (int)(0.8*this.radius*(Math.sin(Math.toRadians(angle + offset))));
            int ex = this.centerX + (int)(this.radius*(Math.cos(Math.toRadians(angle + offset))));
            int ey = this.centerY + (int)(this.radius*(Math.sin(Math.toRadians(angle + offset))));
            g2d.drawLine(sx,sy, ex, ey);
        } else{
            g2d.setColor(Color.white);
            int sx = this.centerX + (int)(0.95*this.radius*(Math.cos(Math.toRadians(angle + offset))));
            int sy = this.centerY + (int)(0.95*this.radius*(Math.sin(Math.toRadians(angle + offset))));
            int ex = this.centerX + (int)(this.radius*(Math.cos(Math.toRadians(angle + offset))));
            int ey = this.centerY + (int)(this.radius*(Math.sin(Math.toRadians(angle + offset))));
            g2d.drawLine(sx,sy, ex, ey);
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(clockControl.getGuess()){
            g2d.setColor(Color.green);
        }else{
            g2d.setColor(Color.black);
        }
        g2d.fillRect(0,0, getWidth(), getHeight());
        this.centerX = getWidth()/2;
        this.centerY = getHeight()/2;
        this.drawClockCircle(g2d);
        for(int a = 0; a < 360; a +=6){
            this.drawNotches(g2d,(float)a,-90);
        }
        this.drawMinuteHand(g2d);
        this.drawHourHand(g2d);
        this.repaint();
    }
}
