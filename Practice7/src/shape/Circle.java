package shape;

import action.Quadrable;

public class Circle implements Quadrable{
    private double radius;
    public Circle(double r){
        radius = r;
    }
    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        return Math.PI*radius*radius;
    }

}
