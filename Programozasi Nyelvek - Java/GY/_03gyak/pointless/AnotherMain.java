package pointless;

import point2d.Point;

public class AnotherMain {
    public static void main(String[] args) {

        point2d.Point p = new point2d.Point();
        System.out.println(p.x + " " + p.y);
        p.x = 6.0;
        p.y = 3.0;
        p.printPoint();

        p.move(1, 1);
        p.printPoint();

        p.mirror(0, 0);
        p.printPoint();

        p.mirror(-1, -1);
        p.printPoint();
    }
}
