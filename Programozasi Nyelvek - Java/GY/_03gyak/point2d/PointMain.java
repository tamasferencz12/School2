package point2d;

public class PointMain {
    public static void main(String[] args) {

        Point p = new Point();
        System.out.println(p.x + " " + p.y);
        p.x = 4.0;
        p.y = 2.0;
        p.printPoint();

        p.move(1, 1);
        p.printPoint();

        p.mirror(0, 0);
        p.printPoint();

        p.mirror(-1, -1);
        p.printPoint();
    }
}
