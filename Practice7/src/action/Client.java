package action;

import java.util.ArrayList;

import shape.Circle;
import shape.Rectangle;
import shape.ShapeUtils;
import shape.Triangle;

public class Client {
    public static void main(String args[]){
        Circle c = new Circle(10.0);
        Triangle t = new Triangle(5,5,5);
        Rectangle r = new Rectangle(10, 6);
        ArrayList<Quadrable> l = new ArrayList<>();
        l.add(c);
        l.add(t);
        l.add(r);
        Quadrable[] qs = {c,t,r};
        System.out.println(ShapeUtils.totalArea(l));
        System.out.println(ShapeUtils.totalArea(qs));
    }
}
