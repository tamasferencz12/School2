package plane.but.not.flying;

import plane.PublicCircle;
import plane.Circle;

public class CircleMain {

    public static void main(String[] args) {

        PublicCircle c = new PublicCircle();
        
        c.x = 5;
        c.y = 4;
        c.radius = 4;

        double z = c.getArea();
        System.out.println("Area: " + z);

        c.setData(5,2,10);
        c.printCircleData();

        z = c.getArea();
        System.out.println("Area: " + z);

        Circle j = new Circle(1,1,2);

        z = j.getArea();
        System.out.println("Area: " + z);

        j.setData(5,2,0);
        j.printCircleData();

        z = j.getArea();
        System.out.println("Area: " + z);

    }
}
