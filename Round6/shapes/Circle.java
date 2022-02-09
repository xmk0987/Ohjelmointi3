import java.io.*;
import java.util.*;
import java.lang.String;

public class Circle implements IShapeMetrics{

    private double radius = 0;

    Circle(double radius){
        this.radius = radius;
    }

    public String toString(){
        return String.format("Circle with radius: %.2f", this.radius);
    }

    public String name(){
        return "circle";
    }

    @Override
    public double area(){
        return PI*(this.radius*this.radius);
    }

    @Override
    public double circumference(){
        return 2*PI*this.radius;
    }


}
