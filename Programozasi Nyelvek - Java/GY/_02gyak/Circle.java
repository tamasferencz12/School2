public class Circle {

    public double x = 0.0;
    public double y = 0.0;
    public double radius = 0.0;

    public void enlarge(double f) {
        this.radius = this.radius * f;
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

}
