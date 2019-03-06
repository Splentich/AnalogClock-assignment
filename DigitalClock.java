import javax.swing.*;
import java.awt.*;

public class DigitalClock {

    /** borders of box */

    static final int BORDER_WIDTH = 50;
    static final int BORDER_HEIGHT = 22;
    final static BasicStroke STROKE = new BasicStroke(0.5f);

    private Graphics2D g2;
    private int hours;
    private int minutes;

    /** digital clock constructor */

    public DigitalClock(Graphics2D g2, int hours, int minutes) {
        this.g2 = g2;
        this.hours = hours;
        this.minutes = minutes;
    }

    /** drawClock draws digital time insidethe box */

    public void drawClock() {
        g2.setStroke(STROKE);
        Rectangle border = new Rectangle(0, 0, BORDER_WIDTH, BORDER_HEIGHT);
        g2.translate(-15, 100);
        g2.draw(border);
        String hour = String.valueOf(hours);
        String minute = String.valueOf(minutes);


        g2.drawString(hour + ":" + minute, 10, 15);
    }
}
