package BallInContainer;
import static java.lang.Math.*;
public class Container {


    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x1, int y1, int width, int height, Ball ball) {

        if (width < 2*ball.getRadius() || height < 2*ball.getRadius())
            System.out.println("Ball with mentioned parameters doesn't fit in such a container. Container size should be increased.");

        this.x2 = this.x1 + width - ball.getRadius();
        this.y2 = this.y1 + height - ball.getRadius();

        this.x1 = x1 + ball.getRadius();
        this.y1 = y1+ ball.getRadius();
    }

    public Container() {
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public boolean Collides(Ball ball){
        return ((ball.getX()>= this.x1 && (ball.getX())<=this.x2) &&
                ( ball.getY()>= this.y1 && (ball.getY())<=this.y2));

    }

    @Override
    public String toString() {
        return "Container{ " +
                "x1= " + x1 +
                ", y1= " + y1 +
                ", x2= " + x2 +
                ", y2= " + y2 +
                '}';
    }
}
