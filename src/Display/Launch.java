package Display;

import javax.swing.*;

public class Launch {

    public static JFrame frame = new JFrame("Drift");
    public static Game g = new Game(frame);
    public static final double CARACCELERATION = 5;

    public static void main(String[] arg){
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(g);
        frame.setVisible(true);
    }

}
