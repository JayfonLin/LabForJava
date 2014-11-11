package shape;

import java.util.ArrayList;

import action.Quadrable;

public class ShapeUtils {
    public static double totalArea(Quadrable[] array){
        double result = 0.0;
        for (Quadrable q:array){
            result += q.getArea();
        }
        return result;
    }
    public static double totalArea(ArrayList<Quadrable> list){
        double result = 0.0;
        for (int i=0; i<list.size(); ++i){
            result += list.get(i).getArea();
        }
        return result;
    }
}
