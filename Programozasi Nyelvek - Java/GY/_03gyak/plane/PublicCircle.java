package plane;

public class PublicCircle {

    public double x = 0;
    public double y = 0;
    public double radius = 1;

    public double getArea(double radius) {
        return this.radius * this.radius * Math.PI;
    }

    public void setData(double a, double b, double c){
        this.x = a;
        this.y = b;
        this.radius = c;
    }

    public void printCircleData(){
        System.out.println("Circle(" + this.x + ", " + this.y + "), radius: " + this.radius + "!");
    }

}
