public class ComplexMain {
    public static void main(String[] args) {

        // 1. complex number
        Complex c1 = new Complex();
        c1.x = 4.0;
        c1.y = 2.0;

        // 2. complex number
        Complex c2 = new Complex();
        c2.x = 2.0;
        c2.y = 1.0;

        double z = c1.abs();
        System.out.println(z);

        c1.add(c2);
        c1.printComplex();

        c1.sub(c2);
        c1.printComplex();

        c1.mul(c2);
        c1.printComplex();

    }
}
