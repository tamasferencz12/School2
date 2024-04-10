package point2d;

public class Point {
    // Ferencz Tamas G0820E

    public double x = 0.0;
    public double y = 0.0;

    public void move(double dx, double dy) {
        x += dx;
        y += dy;

        //PointMainInDefaultPackage.hello(); // ilyen nincs
    }

    public void mirror(double cx, double cy) {
        x = 2 * cx - x;
        y = 2 * cy - y;
    }

    public void printPoint() {
        System.out.println("P(" + this.x + ", " + this.y + ")");
    }

}
