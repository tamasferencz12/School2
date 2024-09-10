class Car {

    int yearModel;
    String make;
    int speed;

    public void accelerate(){
        speed+=5;
    }
    public void brake(){
        speed-=5;
        if(speed < 0){
            speed =0;
        }
    }
}