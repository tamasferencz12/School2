import point2d.*;

public class PointMainInDefaultPackage {

    public static void hello(){
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {

        Point p = new Point();
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
