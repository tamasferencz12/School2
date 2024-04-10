public class Complex {
    // Ferencz Tamas G0820E

    public double x = 0.0;
    public double y = 0.0;

    public void printComplex() {
        System.out.println("C(" + this.x + ", " + this.y + ")");
    }

    public double abs() {
        return Math.sqrt((x * x) + (y * y));
    }

    public void add(Complex a) {
        this.x = this.x + a.x;
        this.y = this.y + a.y;
    }

    public void sub(Complex a) {
        this.x = this.x - a.x;
        this.y = this.y - a.y;
    }

    public void mul(Complex a) {
        this.x = this.x * this.y - a.x * a.y;
        this.y = this.x * a.y + a.x * this.y;
    }

}
