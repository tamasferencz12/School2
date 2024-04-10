
class Point {
    int x, y;

    Point(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
    }
}

public class EA1 {
    public static void main(String[] args) {

        Point p = new Point(0, 1);
        System.out.println(p.x + " " + p.y);
    }
}