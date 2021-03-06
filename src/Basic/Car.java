package Basic;

import Display.Launch;
import Vector.Vector2;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Car extends Rect{

    public int rot = 0;
    private Vector2 vel = new Vector2(0,0), rotn = new Vector2(1,0);

    public Car(int x, int y, int rot){
        super(new Vector2(x, y), new Vector2(x + O.CARSIZE.x, y), new Vector2(x + O.CARSIZE.x, y + O.CARSIZE.y), new Vector2(x, y + O.CARSIZE.y));
        this.rot = rot;
    }

    private Vector2 rotate(Vector2 v, int rot){
        Vector2 centre = getCentre();
        double x = (v.x - centre.x) * Math.cos(Math.toRadians(rot)) - (v.y - centre.y) * Math.sin(Math.toRadians(rot));
        double y = (v.x - centre.x) * Math.sin(Math.toRadians(rot)) + (v.y - centre.y) * Math.cos(Math.toRadians(rot));
        return new Vector2( (x + centre.x), (y + centre.y));
    }

    private Vector2 rotateWithoutCentre(Vector2 v, int rot) {
        double len = v.length();
        double x = Math.cos(Math.toRadians(rot)) * len;
        double y = Math.sin(Math.toRadians(rot)) * len;
        return new Vector2((x), (y));
    }

    public void sendKey(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                rot -= 5;
                break;
            case KeyEvent.VK_D:
                rot += 5;
                break;
            case KeyEvent.VK_W:
                gas();
                break;
            case KeyEvent.VK_S:
                brake();
                break;
        }
    }

    private void gas(){
        double xa = Math.cos(Math.toRadians(rot - 90));
        double ya = Math.sin(Math.toRadians(rot - 90));

        vel.x += xa * Launch.CARACCELERATION;
        vel.y += ya * Launch.CARACCELERATION;
    }

    private void brake(){
        double xa = Math.cos(Math.toRadians(rot + 90));
        double ya = Math.sin(Math.toRadians(rot + 90));

        vel.x += xa * Launch.CARACCELERATION;
        vel.y += ya * Launch.CARACCELERATION;
    }

    private void physics(){
        rotn.x = Math.cos(Math.toRadians(rot - 90));
        rotn.y = Math.sin(Math.toRadians(rot - 90));

        vel.mul(vel.normalized().dot(rotn) * 0.99);
        vel = rotateWithoutCentre(vel, (rot - 90));

        System.out.println(vel.x + " " + vel.y);

        v1.add(vel);
        v2.add(vel);
        v3.add(vel);
        v4.add(vel);
    }

    public void draw(Graphics g){
        physics();
        Vector2 bv1 = rotate(v1, rot);
        Vector2 bv2 = rotate(v2, rot);
        Vector2 bv3 = rotate(v3, rot);
        Vector2 bv4 = rotate(v4, rot);
        g.drawPolygon(new Rect(bv1,bv2,bv3,bv4).getPolygon());
    }

}
