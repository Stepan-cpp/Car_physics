package Display;

import Basic.Car;
import Basic.O;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JPanel implements ActionListener {

    Timer timer = new Timer(50, this);
    JFrame frame;
    Car car = new Car(100,100,90);

    public Game(JFrame frame) {
        this.frame = frame;
        timer.start();
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                car.sendKey(e);
            }
        });
    }

    public void paint(Graphics g){
        g.clearRect(0,0,frame.getWidth(),frame.getHeight());
        car.draw(g);
        int xs = (int)O.CARSIZE.x;
        int ys = (int)O.CARSIZE.x;
        g.drawOval((int)car.getCentre().x - xs/2, (int)car.getCentre().y - ys/2, xs, ys);
    }

    public void physic(){

    }

    public void actionPerformed(ActionEvent e){
       repaint();
       physic();
    }
}
