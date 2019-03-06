import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class ClockComponent extends JComponent{

    private Graphics2D g2;
    private int hours;
    private int minutes;

    /** Default overriden Constructor */

    public ClockComponent() {
        this.hours = LocalTime.now().getHour();
        this.minutes = LocalTime.now().getMinute();
    }

    /** Constructor that accepts hour and minutes*/

    public ClockComponent(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }


    /** Overriding paint method
     *We create 2 objects of analog and digital clocks and draw them
     */

    @Override
    protected void paintComponent(Graphics g){

        g2 = (Graphics2D) g;

        AnalogClock clock = new AnalogClock(g2, hours, minutes);
        clock.drawClock();

        DigitalClock dCLock = new DigitalClock(g2, hours, minutes);
        dCLock.drawClock();
    }
}
