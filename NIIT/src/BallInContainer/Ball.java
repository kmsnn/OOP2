package BallInContainer;

import static java.lang.Math.*;

public class Ball {

    private float x_c;
    private float y_c;
    private int radius;

    private int speed;
    private double direction;

    public Ball(float x_c, float y_c, int radius, int speed, double dir) {
        this.x_c = x_c;
        this.y_c = y_c;

        if (radius == 0)
            System.out.println("Incorrect value of radius");
        else
            this.radius = (radius >0) ? radius : -radius;

        this.speed = speed;

        this.direction = dir/57.3;
    }



    public float getX() {
        return x_c;
    }

    public void setX(float x) {
        this.x_c = x_c;
    }

    public float getY() {
        return y_c;
    }

    public int getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setY(float y) {
        this.y_c = y_c;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }



    public void move(){
        this.x_c += this.speed*cos(this.direction);
        this.y_c += -this.speed*sin(this.direction);
    }


    public void reflectHorizontal(char boundary, Container c1){


        switch (boundary){
            case 't': //top
                {
                this.y_c = 2*c1.getY1() - this.y_c;

                this.direction = -this.direction;}
            break;

            case 'b':{ // bottom

                this.y_c = 2*c1.getY2() - this.y_c;

                this.direction = -this.direction;
            }
            break;

        }

    }

    public void reflectVertical(char boundary,Container c1){

        switch (boundary){
            case 'r': //right
            {
                this.x_c = 2*c1.getX2() - this.x_c;
                this.direction = (this.getDirection()>=0)? (PI - this.direction) : -(PI + this.direction);
                    /*if (this.getDirection()>=0)
                    this.direction = (PI - this.direction);

                if (this.getDirection()<=0)
                    this.direction = -(PI + this.direction);*/

            }
            break;

            case 'l': { // left

                this.x_c = 2 * c1.getX1() - this.x_c;

                this.direction = (this.getDirection() >= 0) ? (PI - this.direction) : -(PI + this.direction);
               /* if (this.getDirection()>=0)
                    this.direction = (PI - this.direction);
                if (this.getDirection()<=0)
                    this.direction = -(PI + this.direction);}*/
            }
            break;

        }

    }

    @Override
    public String toString() {
        return "Ball{" +
                "x_c=" + x_c +
                ", y_c=" + y_c +
                ", radius=" + radius +
                ", speed=" + speed +
                ", direction=" + direction +
                '}';
    }
}

