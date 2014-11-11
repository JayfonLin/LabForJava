package com.shape;

public class Circle implements Comparable<Circle>{
    private int x;
    private int y;
    private double radius;
    public Circle(){
        x = y = 0;
        radius = 1.0;
    }
    public Circle(int x, int y, double r){
        this.x = x;
        this.y = y;
        this.radius = r;
    }
    
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    double getArea(){
        return Math.PI*radius*radius;
    }
    boolean isIntersected(Circle another){
        int xx = this.x - another.getX();
        int yy = this.y - another.getY();
        double rr = this.radius+another.getRadius();
        return xx*xx+yy*yy <= rr*rr;
    }
    boolean contains(Circle another){
        int xx = this.x - another.getX();
        int yy = this.y - another.getY();
        double rr = this.radius-another.getRadius();
        return xx*xx+yy*yy <= rr*rr;
    }
    @Override
    public int compareTo(Circle another){
        if (Math.abs(this.radius - another.getRadius()) < 0.0001)
            return 0;
        return (this.radius - another.getRadius() > 0) ? 1: -1;
    }
    @Override
    public String toString(){
        return String.format("Circle(%d, %d)-%f", x, y, radius);
    }
}
