package Vector;

public class Vector2 extends Vertex2{

    public Vector2(int x, int y){
        super(x, y);
    }

    public Vector2(Vector2 v){
        super(v.x, v.y);
    }

    public Vector2(double x, double y){
        super(x, y);
    }

    public Vector2 add(Vector2 v){
        x += v.x;
        y += v.y;
        return this;
    }

    public Vector2 rem(Vector2 v){
        x -= v.x;
        y -= v.y;
        return this;
    }

    public Vector2 mul(double d){
        x *= d;
        y *= d;
        return this;
    }

    public Vector2 div(double d){
        x /= d;
        y /= d;
        return this;
    }

    public Vector2 mul(Vector2 d){
        x *= d.x;
        y *= d.x;
        return this;
    }

    public Vector2 div(Vector2 d){
        x /= d.x;
        y /= d.y;
        return this;
    }

    public Vector2 normalize(){
        double len = length();
        if(len != 0){
            div(len);
        }
        return this;
    }

    public int deg(){
        return (int)Math.atan2(x, y);
    }

    public Vector2 normalized(){
        return new Vector2(this).normalize();
    }

    public double dot(Vector2 v){
        return x * v.x + y * v.y;
    }

    public double length(){
        return Math.sqrt(x*x+y*y);
    }
}
