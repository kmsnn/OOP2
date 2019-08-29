package BallInContainer;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {

        // Ball parameters
        float _x_c = 1.0f; float _y_c = 2.3f; int _radius = 1; int _speed  = 2;
        int _directory = 30; // in degrees

        // Container parameters
        int _x1 = 0; int _y1 = 0; int _width = 7; int _height = 7;

        Ball ball = new Ball(_x_c, _y_c,_radius,_speed,_directory);

        Container cont = new Container(_x1 ,_y1,_width,_height,ball);

    if    (cont.Collides(ball) == false)
        System.out.println("The ball is outside of container! Enter another initial coordinates of the ball center.");

    else {
        // for debugger
        int inside = 0;
        int outside = 0;
        int t = 0;
        int r = 0;
        int bot = 0;
        int l = 0;

        do {
            if (cont.Collides(ball) == true) {

                inside += 1;
                ball.move();

            } else {

                outside += 1;
                double a = -tan(ball.getDirection());
                double b = ball.getY() - a * ball.getX();
                double Theta = ball.getDirection();

                if ((Theta > 0 && Theta <= PI) && (((cont.getY1() - b) / a >= cont.getX1()) &&
                        ((cont.getY1() - b) / a <= cont.getX2()))) {
                    t += 1;
                    ball.reflectHorizontal('t', cont);

                }

                if ((((Theta >= 0) && (Theta <= PI / 2)) || ((Theta >= -PI / 2) && (Theta <= 0))) &&
                        ((a * cont.getX2() + b) >= cont.getY1() && (a * cont.getX2() + b) <= cont.getY2())) {
                    r += 1;
                    ball.reflectVertical('r', cont);

                }

                if (((Theta >= -PI) && (Theta < 0)) && (((cont.getY2() - b) / a) >= cont.getX1() &&
                        (cont.getY2() - b) / a <= cont.getX2())) {

                    bot += 1;
                    ball.reflectHorizontal('b', cont);

                }
                if ((((Theta >= PI / 2) && (Theta <= PI)) || ((Theta >= -PI) && (Theta <= -PI / 2))) &&
                        ((a * cont.getX1() + b) >= cont.getY1() && (a * cont.getX1() + b) <= cont.getY2())) {

                    l += 1;
                    ball.reflectVertical('l', cont);

                }
            }
        }
        while ((t+r+bot+l)<=6);

    }

	// write your code here
    }
}
