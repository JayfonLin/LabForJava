package shape;

import action.Quadrable;

public class Triangle implements Quadrable{
    private double edge1, edge2, edge3;
    public Triangle(double e1, double e2, double e3){
        edge1 = e1;
        edge2 = e2;
        edge3 = e3;
    }
    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        double s = (edge1+edge2+edge3)/2;
        return Math.sqrt(s*(s-edge1)*(s-edge2)*(s-edge3));
    }

}
