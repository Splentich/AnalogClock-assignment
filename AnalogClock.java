import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.BasicStroke;

public class AnalogClock {

    /**Stroke with different stroke parameters */

    final static BasicStroke BOLD = new BasicStroke(2.0f);
    final static BasicStroke INITIAL = new BasicStroke(1.0f);
    final static BasicStroke HOURS_STROKE = new BasicStroke(5.0f);
    final static BasicStroke MINUTES_STROKE = new BasicStroke(2.0f);

    private Graphics2D g2;
    private int minutes;
    private int hours;

    /** Clock constructor */

    public AnalogClock(Graphics2D g2, int hours, int minutes) {
        this.g2 = g2;
        this.hours = hours;
        this.minutes = minutes;
    }

    /** This method draws a body and other details of Analog Clock */

    protected void drawClock() {
        Rectangle border = new Rectangle(100, 50, 200, 200);

        /** Drawing box and circle for our clock */

        g2.setStroke(BOLD);
        g2.draw(border);
        g2.drawOval(100, 50, 200, 200);

        /** Drawing time bars and numbers */

        g2.setStroke(INITIAL);
        drawBars();
        drawNumbers();

        /** Drawing hour and minute hands */

        drawHourHand(hours);
        drawMinutesHand(minutes);
    }


    /** This method draws bars
     * We draw 12 bars each much specific time on clock panel
     * To approach this, we use for loop statement where we draw a bar and then rotate in by 30 degrees
     * using rotate and converting degree to radians.
     * We took 30 degrees as default value because 360 (circle degree) / 12 (hours) = 30
     */

    private void drawBars(){

        g2.translate(200,150);


        for (int i = 1; i < 13; i++) {

            /** stroke bold bar at 12, 3, 6 and 9 o'clock */

            if(i == 1 || i == 4 || i == 7 || i == 10){

                g2.setStroke(BOLD);
                g2.drawLine(0, 90, 0, 100);
                g2.rotate(Math.toRadians(30));

            }else {

                g2.setStroke(INITIAL);
                g2.drawLine(0, 90, 0, 100);
                g2.rotate(Math.toRadians(30));
            }


        }
    }

    /** To draw numbers that represent a time we use the same approach as we did drawing the bars
     * However in this method we used sin and cos to find a point on circle circumference.
     * */

    private void drawNumbers() {

        g2.translate(-3,5);

        int offset = 80;

        for (int i = 1; i < 13;i++){

            g2.drawString(String.valueOf(i),
                    (int)(offset * Math.sin(Math.toRadians(i*30))),
                    (int)(-offset * Math.cos(Math.toRadians(i*30)))
            );
        }
    }


    /**  Method drawHourHand() accept hours to set hand on time that user specified
     * degree for rotation of hand calculated by formula 180 + hours * 360 / 12
     * where 180 degree points backward from 6 to 12 and then we turn a hand by multiplying
     * hours by angle of circle
     * At the end we rotate coordinates by -degree to set original position
     * Otherwise minute hand will not be displayed correctly
     * */

    private void drawHourHand(int hours) {


        int degrees = 180 + hours * 30;

        g2.setStroke(HOURS_STROKE);
        g2.rotate(Math.toRadians(degrees));
        g2.drawLine(0, 0, 0, 50);
        g2.rotate(Math.toRadians(-degrees));
    }

    /** DrawMinuteHand use absolutely the same approach that method drawHourUse.
     * Please follow the drawHourHand() for documentation
     */

    private void drawMinutesHand(int minutes) {

        int degrees = 180 + minutes * 6;

        g2.setStroke(MINUTES_STROKE);
        g2.rotate(Math.toRadians(degrees));
        g2.drawLine(0, 0, 0, 70);
        g2.rotate(Math.toRadians(-degrees));
    }
}