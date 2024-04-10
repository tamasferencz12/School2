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

        Point2 p2 = new Point2();
        p2.x = 6;
        p2.y = 4;

        Point2 p3 = new Point2();
        p3.x = 2;
        p3.y = 1;

        p2.move(1, 1);
        p2.printPoint();

        p2.mirror(p3);
        p2.printPoint();

        p2.distance(p3);
        p2.printPoint();

    }
}
