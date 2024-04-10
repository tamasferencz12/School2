public class CircleMain {
    public static void main(String[] args) {

        Circle c = new Circle();
        c.x = 5.0;
        c.y = 4.0;
        c.radius = 4.0;

        c.enlarge(2);
        System.out.println(c.radius);

        double z = c.getArea();
        System.out.println("Area: " + z);
    }
}
