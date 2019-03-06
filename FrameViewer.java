import javax.swing.*;







public class FrameViewer {
    public static void main(String[] args) {


        /** prompts user to enter a time
         * Not much checks have been made
         * We assume user will enter a date in hh:mm format
         * Programs checks for correct time numbers. For example 44 hours time is not allowed
         * If time is incorrect, program terminates its execution
         */

        String input = JOptionPane.showInputDialog(null, "Enter a time in the following format hh:mm :");

        ClockComponent clock = null;

        /** if cancel button is being pressed */

        if(input == null){

            clock = new ClockComponent();
        }
        else {

            /** parsing hours and minutes */
            int hours = getHour(input);
            int minutes = getMinute(input);

            /** checking if date is correct */

            if(dateIsValid(hours,minutes))
                clock = new ClockComponent(hours,minutes);
            else {
                JOptionPane.showMessageDialog(null, "Incorrect time");
                System.exit(0);

            }

        }

        /** creating and initializing the frame
         * Setting properties
         * Adding clock component to the frame
         * Setting the frame to be visible
         */

        JFrame frame = new JFrame();

        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 400;


        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setTitle("Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(clock);

        frame.setVisible(true);

    }


    public static int getHour(String input){

       String[] time = input.split(":");
       String h = time[0];
       int hour = Integer.parseInt(h);

       return hour;

   }

    public static int getMinute(String input){

        String[] time = input.split(":");
        String m = time[1];
        int minute = Integer.parseInt(m);

        return minute;
    }

    public static boolean dateIsValid(int hours, int minutes){

        return (hours < 24 && minutes < 60) ? true : false;

    }

}
