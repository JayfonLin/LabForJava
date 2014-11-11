package shape;

import action.Quadrable;

public class Rectangle implements Quadrable{
    private double width;
    private double height;
    public Rectangle(double w, double h){
        width = w;
        height = h;
    }
    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        return width*height;
    }

}
