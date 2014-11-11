package com.shape;

import java.util.Arrays;
import java.util.Random;

public class TestCircle {
    static Circle[] createArray(){
        Circle cs[] = new Circle[10];
        Random rand = new Random();
        for (int i = 0; i < 10; ++i){
            Circle c = new Circle(rand.nextInt(), rand.nextInt(), rand.nextDouble());
            cs[i] = c;
        }
        return cs;
    }
    static void sort(Circle cs[]){
        Arrays.sort(cs, 0, cs.length);
    } 
    static double computeArea(Circle cs[]){
        double ans = 0.0;
        for (int i = 0; i < cs.length; ++i){
            boolean flag = false;
            for (int j = i+1; j < cs.length; ++j){
                if (cs[i].isIntersected(cs[j]) || cs[i].contains(cs[j])){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                ans += cs[i].getArea();
            }
        }
        return ans;
    }
    public static void main(String args[]){
        Circle cs[] = createArray();
        sort(cs);
        for (int i = 0; i < cs.length; ++i){
            System.out.println(cs[i]);
        }
        System.out.println(computeArea(cs));
    }
}
