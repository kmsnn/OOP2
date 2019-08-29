package NIITTComplex;


import java.util.Objects;

import static java.lang.Math.*;

public class MyComplexClass {

    private double real;
    private double imag;
    private String name;

    public MyComplexClass() {
    }

    public MyComplexClass(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        if (this.imag>0) {
            return ("MyComplexClass{" +
                    +real + "+"
                    + imag + " i" +
                    '}');
        }
        else {
            return "MyComplexClass{ " +
                    +real + " "
                    + imag + " i" +
                    '}';
        }
    }

    public boolean isReal(){
        if (this.real != 0)
            return true;
        else
            return false;
    }

    public boolean isImaginary(){
        if (this.imag != 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        MyComplexClass that = (MyComplexClass) obj;
        return (this.real != 0 && real == ((MyComplexClass) obj).real
                && imag != 0 && imag == ((MyComplexClass) obj).imag);
    }

    public boolean equals(double real, double imag) {

        return (this.real != 0 && this.real == real && real!=0
                && this.imag != 0 && this.imag == imag && imag!=0);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + (int) real;
        result = 31*result + (int) imag;
        return result;
    }


    public double getMagnitude(){
        return sqrt(this.real*this.real+this.imag*this.imag);
    }

    public double getArgument(){
        if (this.real!=0)
         return atan(this.imag/this.real);
        else
            return PI/2;
     }

    public MyComplexClass add(MyComplexClass right){
        this.real = this.real+right.real;
        this.imag = this.imag + right.imag;
        return this;

    }

    public MyComplexClass addNew(MyComplexClass right){

        MyComplexClass New = new MyComplexClass(this.real+right.real,this.imag + right.imag);
        return New;
    }

    public MyComplexClass subtract(MyComplexClass right){
        this.real = this.real-right.real;
        this.imag = this.imag - right.imag;
        return this;

    }

    public MyComplexClass subtractNew(MyComplexClass right){

        MyComplexClass New = new MyComplexClass(this.real-right.real,this.imag - right.imag);
        return New;
    }

    public MyComplexClass multiply(MyComplexClass right){
            this.real = this.real*right.real - this.imag*right.imag;
            this.imag = this.imag*right.real - this.real*right.imag;
            return this;
    }



    public MyComplexClass getConjugation(){
        this.imag = -this.imag;
        return this;
    }

    public MyComplexClass divide(MyComplexClass right){
        if (this.getMagnitude() != 0) {
            right.multiply(this.getConjugation());
            this.real = right.real / this.getMagnitude();
            this.imag = right.imag / this.getMagnitude();
            return this;
        }
        else {
            System.out.println("Division by zero!");
            return this;
        }
    }

}

