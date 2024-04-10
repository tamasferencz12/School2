package plane;

public class Circle {

    private double x = 0;
    private double y = 0;
    private double radius = 1;

    /*
    public double getX(){
        return this.x;
    }

    public void setX(double x){
        this.x = x;
    }
    */

    public Circle(double k, double m, double r){
        if(r <= 0){
            throw new IllegalArgumentException("Radius must be greater than 0!");
        }else{
            this.x = k;
            this.y = m;
            this.radius = r;
        }
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    public void setData(double a, double b, double c){
        if(c <= 0){
            throw new IllegalArgumentException("Radius must be greater than 0!");
        }else{
            this.x = a;
            this.y = b;
            this.radius = c;
        }
        
    }

    public void printCircleData(){
        System.out.println("Circle(" + this.x + ", " + this.y + "), radius: " + this.radius + "!");
    }

}
