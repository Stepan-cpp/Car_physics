package Basic;

import Vector.Vector2;

import java.awt.*;

public class Rect {
    public Vector2 v1, v2, v3, v4;

    public Rect(Vector2 v1, Vector2 v2, Vector2 v3, Vector2 v4) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }

    public Vector2 getCentre() {
        return new Vector2(((v1.x + v2.x + v3.x + v4.x) / 4),((v1.y + v2.y + v3.y + v4.y) / 4));
    }

    public Polygon getPolygon(){
        int x[] = {(int)v1.x, (int)v2.x, (int)v3.x, (int)v4.x}, y[] = {(int)v1.y, (int)v2.y, (int)v3.y, (int)v4.y};
        return new Polygon(x, y, 4);
    }
}
