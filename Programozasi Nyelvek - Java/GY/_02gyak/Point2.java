public class Point2 {
    // Ferencz Tamas G0820E

    public double x = 0.0;
    public double y = 0.0;

    // Point(){}

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public void mirror(Point2 p) {
        x = 2 * p.x - x;
        y = 2 * p.y - y;
    }

    public void printPoint() {
        System.out.println("P(" + this.x + ", " + this.y + ")");
    }

    public double distance(Point2 p) {
        return Math.sqrt(((this.x - p.y) * (this.x - p.x)) + ((this.y - p.y) * (this.x - p.y)));
    }

}
