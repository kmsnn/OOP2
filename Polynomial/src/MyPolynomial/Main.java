package MyPolynomial;
import static java.lang.Math.*;
public class Main {

    public static void main(String[] args) {

        int n1 = 0;
        int n2 = 2;
        double interval = 50;

        MyDouble _coeff1[] = new MyDouble [n1+1];
        MyDouble _coeff2[] = new MyDouble [n2+1];

        for (int i= 0; i<n1+1; i++)
            _coeff1[i] = new MyDouble(-interval +random()*2*interval);

        for (int i= 0; i<n2+1; i++)
            _coeff2[i] = new MyDouble(-interval + random()*2*interval);


        MyPolynomial p1 = new MyPolynomial(_coeff1);
        MyPolynomial p2 = new MyPolynomial(_coeff2);

        System.out.println("First polynomial p1: "+ p1.toString());

        double x = -interval + random()*2*interval;
        System.out.format("\nEvaluate polynomial p1 with x = %.3f", x);
        System.out.format(": %.3f", p1.evaluate(x));

        System.out.println("\nSecond polynomial p2: "+ p2.toString());

        MyPolynomial p3 = new MyPolynomial();
        p3 = p1.add(p2);

        System.out.println("\nAddition p1 with p2: "+ p3.toString());
        System.out.println("\n");

        MyPolynomial p4 = new MyPolynomial();
        p4 = p1.getMultiply(p2);

        System.out.println("Multiplication p1 with p2: "+ p4.toString());
        System.out.println("\n");

        // write your code here
    }
}