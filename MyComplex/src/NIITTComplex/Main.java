package NIITTComplex;
import static java.lang.Math.*;
public class Main {

    public static void main(String[] args) {

    double interval = -100;
    double _real1 = interval + random()*2*interval;
    double _imag1 = interval + random()*2*interval;
    double _real2 = interval + random()*2*interval;
    double _imag2 = interval + random()*2*interval;

    MyComplexClass c1 = new MyComplexClass(_real1,_imag1);
    MyComplexClass c3 = new MyComplexClass(_real1,_imag1);

    MyComplexClass c2 = new MyComplexClass(_real2,_imag2);

    System.out.println("Initial first complex number c1: " + c1.toString()  );
    System.out.format("It's magnitude: %.2f",c1.getMagnitude());
    System.out.format("; argument: %.2f", c1.getArgument()); System.out.println(" rad");
    System.out.println("\nConjugated first complex number: " + c3.getConjugation());


    System.out.println("\nComparison с1 with c3:");
    System.out.println("c3: " + c3.getConjugation().toString());
    System.out.println("c1 hashcode: " + c1.hashCode() + "; c3 hashcode: " + c3.hashCode());
    System.out.println("Method equals for c1 and c2: " + c1.equals(c3));


    System.out.println("\nInitial second complex number c2: " + c2.toString()  );
    System.out.println("c2 is added with c1: " + c1.addNew(c2).toString());
    System.out.println("c2 is subtracted from c1: " + c1.subtractNew(c2).toString());
    System.out.println("c2 is multiplied into c1: " + c1.multiply(c2).toString());
    System.out.format("c2 is divided into c1: " + c1.divide(c2).toString());

        System.out.println("\n");// write your code here
    }
}
