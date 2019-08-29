package MyPolynomial;

import static java.lang.Math.*;

public class MyPolynomial {

    private int n;
    private MyDouble [] coeffs;

    public MyPolynomial(MyDouble... coeffs) {
        this.coeffs = coeffs;
        this.n = this.coeffs.length-1;
    }

    public MyPolynomial() {
    }

    @Override
    public String toString() {

        StringBuilder p1 = new StringBuilder("" + this.coeffs[0].getMycoeff());

        for (int i =1; i<this.n+1; i++) {
            if (this.coeffs[i].getMycoeff() >= 0)
                p1.append("+" + this.coeffs[i].getMycoeff() + "x^" + i);
            if (this.coeffs[i].getMycoeff() < 0)
                p1.append(this.coeffs[i].getMycoeff() + "x^" + i);
        }

        return (String) p1.toString();
    }

    public double evaluate(double x)
    {
        double result0 = this.coeffs[0].getMycoeff();
        for (int i =1; i< n+1; i++)
            result0 = result0 + this.coeffs[i].getMycoeff()*pow(x,i);
        return result0;
    }

    public MyPolynomial add(MyPolynomial right) {

        if (this.coeffs.length >= right.coeffs.length) {
            MyDouble [] _coeffs = new MyDouble[this.coeffs.length];

            for (int j = 0; j<_coeffs.length;j++)
                _coeffs[j] = new MyDouble(0.0);

            MyPolynomial result = new MyPolynomial(_coeffs);

            for (int i = 0; i < right.coeffs.length; i++)
                result.coeffs[i].setMycoeff(this.coeffs[i].getMycoeff() + right.coeffs[i].getMycoeff());


            for (int i = right.coeffs.length ; i < this.coeffs.length; i++)
                result.coeffs[i].setMycoeff(this.coeffs[i].getMycoeff());

            result.n = this.coeffs.length-1;

            return result;
        }
        else {

            MyDouble [] _coeffs = new MyDouble[right.coeffs.length];

            for (int j = 0; j<_coeffs.length;j++)
                _coeffs[j] = new MyDouble(0.0);

            MyPolynomial result = new MyPolynomial(_coeffs);

            for (int i = 0; i < this.coeffs.length; i++)
                result.coeffs[i].setMycoeff(this.coeffs[i].getMycoeff() + right.coeffs[i].getMycoeff());

            for (int i = this.coeffs.length; i < right.coeffs.length; i++)
                result.coeffs[i].setMycoeff(right.coeffs[i].getMycoeff());

            result.n = right.coeffs.length-1;

            return result;
        }

    }

    public MyPolynomial getMultiply(MyPolynomial right)
    {
        MyDouble [] _coeffs = new MyDouble[right.coeffs.length + right.coeffs.length];

        for (int j = 0; j<_coeffs.length;j++)
            _coeffs[j] = new MyDouble(0.0);

        MyPolynomial mul = new MyPolynomial(_coeffs);

        for (int i = 0; i < this.coeffs.length; i++) {
            for (int j = 0; j< right.coeffs.length; j++)
                mul.coeffs[i+j].setMycoeff(this.coeffs[i].getMycoeff() * right.coeffs[j].getMycoeff());
        }

        mul.n = (this.coeffs.length + right.coeffs.length-2);

        return mul;
    }
}







